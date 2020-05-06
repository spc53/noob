package com.lcu.res.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcu.res.dao.OrderDetailMapper;
import com.lcu.res.dao.OrderMapper;
import com.lcu.res.po.Food;
import com.lcu.res.po.Order;
import com.lcu.res.po.OrderDetail;
import com.lcu.res.po.PageBean;
import com.lcu.res.po.User;

@Service
public class OrderServicelmpl implements OrderService {

	@Autowired
	OrderMapper ordermapper;
	
	@Autowired
	OrderDetailMapper orderdetailmapper;
	
	//向餐饮购物车添加餐饮
	@SuppressWarnings("unchecked")
	@Override
	public String putCart(Food foodinfo, String quantity, HttpSession session) {
		OrderDetail od = new OrderDetail();
		Map<String, OrderDetail> map = null;
		if (session.getAttribute("FOODCART") != null) {
			map = (HashMap<String, OrderDetail>)session.getAttribute("FOODCART");//购物车里有餐饮
		} else {
			map = new HashMap<String, OrderDetail>();//购物车里没有餐饮
		}
		
		od.setRestaurantNumber(foodinfo.getRestaurantNumber());
		od.setFoodNumber(foodinfo.getFoodNumber());
		od.setPictureName(foodinfo.getPictureName());
		od.setFoodName(foodinfo.getFoodName());
		od.setUnitPrice(foodinfo.getUnitPrice());
		if (map.containsKey(foodinfo.getFoodNumber())) {//购物车里有这个餐饮时
			int qt = 0;
			if (quantity != null) {
				qt = Integer.parseInt(quantity);
			} else {
				qt = map.get(foodinfo.getFoodNumber()).getQuantity() + 1;//添加同一个餐饮数量加一
			}
			od.setQuantity(qt);
			BigDecimal qt2 =new BigDecimal(qt);
			BigDecimal amount = new BigDecimal(0);
			BigDecimal unitPrice = foodinfo.getUnitPrice();
			amount = unitPrice.multiply(qt2);
			od.setAmount(amount);
		} else {//购物车里没有这个餐饮时
			od.setQuantity(1);
			od.setAmount(foodinfo.getUnitPrice());
		}
		od.setFinishStatus(1);
		
		map.put(foodinfo.getFoodNumber(), od);
		session.setAttribute("FOODCART", map);
		return "order/o_cart";
	}

	//删除购物车餐饮信息
	@SuppressWarnings("unchecked")
	@Override
	public String deleteCart(String foodNumber, String restaurantNumber, HttpSession session) {
		Map<String, OrderDetail> map = (HashMap<String, OrderDetail>)session.getAttribute("FOODCART");
		OrderDetail od = map.get(foodNumber);
		if (od.getQuantity() > 1) {
			int q = od.getQuantity() - 1;
			od.setQuantity(q);
			map.put(foodNumber, od);
		} else {
			map.remove(foodNumber);
		}
		session.setAttribute("FOODCART", map);
		return "order/o_cart";
	}
	
	//清除餐饮购物车里的内容
	@Override
	public String clearMap(HttpSession session) {
		Map<String, OrderDetail> map = null;
		session.setAttribute("FOODCART", map);
		return "order/o_cart";
	}

	//保存订单信息
	@Override
	public void saveOrder(Order order) {
		ordermapper.saveOrder(order);
	}

	//保存订单明细信息
	@Override
	public void saveOrderDetail(OrderDetail value) {
		orderdetailmapper.saveOrderDetail(value);
	}

	//分页查询订单信息
	@Override
	public PageBean<Order> findByPage(int currentPage, int pageSize, String condition, String startDate, String endDate, String orderNumber, HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		PageBean<Order> pageBean = new PageBean<>();
		User userInfo = (User)session.getAttribute("USERINFO");
		
		//当前页数
		pageBean.setCurrPage(currentPage);
		
		//每页显示的记录数
		pageBean.setPageSize(pageSize);
		
		map.put("restaurantNumber", userInfo.getRestaurantNumber());
		int status = 1;
		
		if (startDate != "") {
			map.put("startDate", startDate);
		}
		
		if (endDate != "") {
			map.put("endDate", endDate);
		}
		
		if (orderNumber != "") {
			map.put("orderNumber", orderNumber);
		}
		
		if (condition != null) {
			if ("payStatus".equals(condition)) {
				map.put("payStatus", status);//未支付订单
			}
			
			if ("finishStatus".equals(condition)) {
				map.put("finishStatus", status);//未完成订单
			}
			
			if ("queuingStatus".equals(condition)) {
				map.put("queuingStatus", status);//排队中订单
			}
		}
		
		//总记录数
		int totalCount = ordermapper.selectCount(map);
		pageBean.setTotalCount(totalCount);
		
		//总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		
		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		
		//每页显示的数据
		List<Order> lists = ordermapper.findByPage(map);
		pageBean.setLists(lists);
		
		return pageBean;
	}

	//查询订单信息
	@Override
	public Order selectByonAndrn(String orderNumber, String restaurantNumber) {
		Order order = new Order();
		order.setOrderNumber(orderNumber);
		order.setRestaurantNumber(restaurantNumber);
		return ordermapper.selectByonAndrn(order);
	}

	//查询订单详细信息
	@Override
	public List<OrderDetail> selectodByonAndrn(String orderNumber, String restaurantNumber) {
		OrderDetail od = new OrderDetail();
		od.setRestaurantNumber(restaurantNumber);
		od.setOrderNumber(orderNumber);
		return orderdetailmapper.selectodByonAndrn(od);
	}

	//删除订单详细信息
	@Override
	public void deleteOrderD(String orderNumber, String restaurantNumber) {
		OrderDetail od = new OrderDetail();
		od.setRestaurantNumber(restaurantNumber);
		od.setOrderNumber(orderNumber);
		orderdetailmapper.deleteOrderD(od);
	}

	//删除订单信息
	@Override
	public void deleteOrder(String orderNumber, String restaurantNumber) {
		Order order = new Order();
		order.setOrderNumber(orderNumber);
		order.setRestaurantNumber(restaurantNumber);
		ordermapper.deleteOrder(order);
	}
	
}
