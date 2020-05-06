package com.lcu.res.po;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Restaurant {

	//店编号
	private String restaurantNumber;
	
	//店名
	private String restaurantName;
	
	//餐馆电话
	private String restaurantTelephone;
	
	//开店地址
	private String restaurantAddress;
	
	//店长
	private String restaurantManager;
	
	//创建时间
	private Date creationTime;		
	
	//修改时间
	private Date changeTime;

	public String getRestaurantNumber() {
		return restaurantNumber;
	}

	public void setRestaurantNumber(String restaurantNumber) {
		this.restaurantNumber = restaurantNumber;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantTelephone() {
		return restaurantTelephone;
	}

	public void setRestaurantTelephone(String restaurantTelephone) {
		this.restaurantTelephone = restaurantTelephone;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public String getRestaurantManager() {
		return restaurantManager;
	}

	public void setRestaurantManager(String restaurantManager) {
		this.restaurantManager = restaurantManager;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
		
}
