package com.lcu.res.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.lcu.res.po.Food;
import com.lcu.res.po.Order;
import com.lcu.res.po.OrderDetail;
import com.lcu.res.po.PageBean;

public interface OrderService {

	String putCart(Food foodinfo, String quantity, HttpSession session);

	String clearMap(HttpSession session);

	void saveOrder(Order order);

	void saveOrderDetail(OrderDetail value);

	String deleteCart(String foodNumber, String restaurantNumber, HttpSession session);

	PageBean<Order> findByPage(int currentPage, int pageSize, String condition, String startDate, String endDate, String orderNumber, HttpSession session);

	Order selectByonAndrn(String orderNumber, String restaurantNumber);

	List<OrderDetail> selectodByonAndrn(String orderNumber, String restaurantNumber);

	void deleteOrderD(String orderNumber, String restaurantNumber);

	void deleteOrder(String orderNumber, String restaurantNumber);

}
