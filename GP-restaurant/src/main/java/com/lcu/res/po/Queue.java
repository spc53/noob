package com.lcu.res.po;

import org.springframework.stereotype.Component;

@Component
public class Queue {

	//店编号
	private String restaurantNumber;
	
	//订单编号
	private String orderNumber;
	
	//排队编号
	private String queueNumber;
	
	//排队状态
	private Integer queueStatus;

	public String getRestaurantNumber() {
		return restaurantNumber;
	}

	public void setRestaurantNumber(String restaurantNumber) {
		this.restaurantNumber = restaurantNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getQueueNumber() {
		return queueNumber;
	}

	public void setQueueNumber(String queueNumber) {
		this.queueNumber = queueNumber;
	}

	public Integer getQueueStatus() {
		return queueStatus;
	}

	public void setQueueStatus(Integer queueStatus) {
		this.queueStatus = queueStatus;
	}
	
}
