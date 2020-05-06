package com.lcu.res.po;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Order {

	// 店编号
	private String restaurantNumber;

	// 订单编号
	private String orderNumber;

	// 桌号
	private String tableNumber;

	// 人数
	private Integer peopleNum;

	// 员工名/创建人
	private String actualName;

	// 总金额
	private BigDecimal totalAmount;

	// 支付状态
	private Integer payStatus;

	// 完成状态
	private Integer finishStatus;

	// 排队状态
	private Integer queuingStatus;

	// 创建时间
	private Date creationTime;

	// 支付时间
	private Date payTime;

	// 修改时间
	private Date changeTime;

	// 对应详细信息
	private List<OrderDetail> od;

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

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getActualName() {
		return actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getFinishStatus() {
		return finishStatus;
	}

	public void setFinishStatus(Integer finishStatus) {
		this.finishStatus = finishStatus;
	}

	public Integer getQueuingStatus() {
		return queuingStatus;
	}

	public void setQueuingStatus(Integer queuingStatus) {
		this.queuingStatus = queuingStatus;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public List<OrderDetail> getOd() {
		return od;
	}

	public void setOd(List<OrderDetail> od) {
		this.od = od;
	}

}
