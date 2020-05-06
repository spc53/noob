package com.lcu.res.po;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Food {

	//店编号
	private String restaurantNumber;
	
	//餐饮编号
	private String foodNumber;
	
	//图片名
	private String pictureName;
	
	//餐饮名
	private String foodName;
	
	//种类
	private String kindName;
	
	//主要原料
	private String mainIngreadient;
	
	//单价
	private BigDecimal unitPrice;
	
	//是否卖完/出售状态
	private Integer saleStatus;

	public String getRestaurantNumber() {
		return restaurantNumber;
	}

	public void setRestaurantNumber(String restaurantNumber) {
		this.restaurantNumber = restaurantNumber;
	}

	public String getFoodNumber() {
		return foodNumber;
	}

	public void setFoodNumber(String foodNumber) {
		this.foodNumber = foodNumber;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getMainIngreadient() {
		return mainIngreadient;
	}

	public void setMainIngreadient(String mainIngreadient) {
		this.mainIngreadient = mainIngreadient;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Integer saleStatus) {
		this.saleStatus = saleStatus;
	}
	
}
