package com.lcu.res.po;

import org.springframework.stereotype.Component;

@Component
public class Table {

	// 店编号
	private String restaurantNumber;

	// 餐桌号
	private String tableNumber;

	// 状态
	private Integer status;

	// 座位数
	private Integer seatNum;
	
	//被占用的座位数
	private Integer occupySeatNum;

	// 空座位数
	private Integer emptySeatNum;

	public String getRestaurantNumber() {
		return restaurantNumber;
	}

	public void setRestaurantNumber(String restaurantNumber) {
		this.restaurantNumber = restaurantNumber;
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public Integer getEmptySeatNum() {
		return emptySeatNum;
	}

	public void setEmptySeatNum(Integer emptySeatNum) {
		this.emptySeatNum = emptySeatNum;
	}

	public Integer getOccupySeatNum() {
		return occupySeatNum;
	}

	public void setOccupySeatNum(Integer occupySeatNum) {
		this.occupySeatNum = occupySeatNum;
	}
	
}
