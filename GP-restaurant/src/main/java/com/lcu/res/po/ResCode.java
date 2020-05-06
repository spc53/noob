package com.lcu.res.po;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ResCode {

	//编号类型
	private String codeType;
	
	//编号
	private String number;
	
	//修改时间
	private Date changeTime;

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	
}
