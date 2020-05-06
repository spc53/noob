package com.lcu.res.controller;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcu.res.po.Food;
import com.lcu.res.po.Order;
import com.lcu.res.po.OrderDetail;
import com.lcu.res.po.PageBean;
import com.lcu.res.po.User;
import com.lcu.res.service.CodeService;
import com.lcu.res.service.FoodService;
import com.lcu.res.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	FoodService foodservice;
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	CodeService codeservice;
	
	@RequestMapping("/{path}")
	public String path(@PathVariable String path) {
		if ("o_cart".equals(path)) {
			path = "order/" + path;
		}
		return path;
	}
	
	//向餐饮购物车添加餐饮
	@RequestMapping("/putCart")
	public String putCart(String foodNumber, String restaurantNumber, String quantity, HttpSession session) {
		
		Food foodinfo = foodservice.selectByresAndfood(foodNumber, restaurantNumber);
		if (foodinfo == null) {
			return "";  //错误画面
		}
		
		return orderservice.putCart(foodinfo, quantity, session);
	}
	
	//删除购物车餐饮信息
	@RequestMapping("/deleteCart")
	public String deleteCart(String foodNumber, String restaurantNumber, HttpSession session) {
		return orderservice.deleteCart(foodNumber, restaurantNumber, session);
	}
	
	//清除餐饮购物车里的内容
	@RequestMapping("/clearMap")
	public String clearMap(HttpSession session) {
		return orderservice.clearMap(session);
	}
	
	//生成订单
	@RequestMapping("/createOrder")
	public String createOrder(HttpSession session, Model model, String tableNumber, String peopleNum) {
		//获取用户信息
		User userInfo = (User)session.getAttribute("USERINFO");
		
		//生成订单编号
		String codeType = "ORD";
		String orderNumber = codeservice.createCode(codeType, userInfo.getRestaurantNumber());
		
		//创建订单信息
		Order order = new Order();
		order.setRestaurantNumber(userInfo.getRestaurantNumber());
		order.setOrderNumber(orderNumber);
		order.setActualName(userInfo.getActualName());
		order.setPayStatus(1);
		order.setFinishStatus(1);
		order.setQueuingStatus(1);
		if (tableNumber != null && tableNumber != "") {
			order.setTableNumber(tableNumber);
		}
		if (peopleNum != null && peopleNum != "") {
			int pu = Integer.parseInt(peopleNum);
			order.setPeopleNum(pu);
		}
		//计算订单总金额
		BigDecimal totalAmount = new BigDecimal(0);
		@SuppressWarnings("unchecked")
		Map<String, OrderDetail> map = (HashMap<String, OrderDetail>)session.getAttribute("FOODCART");
		
		Iterator<Entry<String, OrderDetail>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, OrderDetail> entry = iterator.next();
			totalAmount = totalAmount.add(entry.getValue().getAmount());
		}
		order.setTotalAmount(totalAmount);
		
		//存储订单信息
		orderservice.saveOrder(order);
		
		//存储订单的详细信息
		Iterator<Entry<String, OrderDetail>> iterator2 = map.entrySet().iterator();
		while (iterator2.hasNext()) {
			Entry<String, OrderDetail> entry = iterator2.next();
			entry.getValue().setOrderNumber(orderNumber);
			orderservice.saveOrderDetail(entry.getValue());
		}
		
		//更新编号表
		codeservice.updateCode(userInfo.getRestaurantNumber(), codeType);
	
		model.addAttribute("ORDERCART", order);
		model.addAttribute("ORDERDETAILCART", map);
		
		//清除Map
		map = null;
		session.setAttribute("FOODCART", map);
		
		return "order/orderInfo";
	}
	
	//所有订单信息一览
	@RequestMapping("/showOrder")
	public String showOrder(@RequestParam(value="currentPage", defaultValue="1", required=false)int currentPage, Model model, String condition, String startDate, String endDate, String orderNumber, HttpSession session) {
		PageBean<Order> pageBean = orderservice.findByPage(currentPage, 5, condition, startDate, endDate, orderNumber,session);
		if (pageBean.getTotalCount() != 0) {
			model.addAttribute("ORDERPAGEMSG", pageBean);
			model.addAttribute("CONDITION", condition);
			model.addAttribute("STARTDATE", startDate);
			model.addAttribute("ENDDATE", endDate);
			model.addAttribute("ORDERNUMBER", orderNumber);
		}
		return "order/o_update";
	}
	
	//订单详细信息
	@RequestMapping("/orderDinfo")
	public String orderDinfo(String orderNumber, String restaurantNumber, Model model) {
		
		String num = orderNumber.substring(orderNumber.length() - 4);
		Order order = orderservice.selectByonAndrn(orderNumber, restaurantNumber);
		List<OrderDetail> od = orderservice.selectodByonAndrn(orderNumber, restaurantNumber);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateString = simpleDateFormat.format(order.getCreationTime());
		
		model.addAttribute("CTIME", dateString);
		model.addAttribute("NUM", num);
		model.addAttribute("ORDER", order);
		model.addAttribute("ODLIST", od);
		
		return "order/order_details_info";
	}
	
	//删除订单，订单详情
	@RequestMapping("/deleteOrder")
	public String deleteOrder(String orderNumber, String restaurantNumber) {
		
		orderservice.deleteOrderD(orderNumber, restaurantNumber);
		orderservice.deleteOrder(orderNumber, restaurantNumber);
		return "redirect:showOrder";
	}
	
	//后台显示订单
	@RequestMapping("/showBackOrder")
	public String showBackOrder(@RequestParam(value="currentPage", defaultValue="1", required=false)int currentPage, Model model, HttpSession session) {
		PageBean<Order> pageBean = orderservice.findByPage(currentPage, 4, "finishStatus", "", "", "", session);
		if (pageBean.getTotalCount() != 0) {
			model.addAttribute("BACKORDER", pageBean);
		}
		return "main/main_back_kitchen";
	}
	
}
