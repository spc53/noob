package com.lcu.res.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcu.res.dao.CodeMapper;
import com.lcu.res.dao.ResCodeMapper;
import com.lcu.res.po.Code;
import com.lcu.res.po.ResCode;

@Service
public class CodeServicelmpl implements CodeService{

	@Autowired
	CodeMapper codemapper;
	
	@Autowired
	ResCodeMapper rescodemapper;
	
	//生成编号
	@Override
	public String createCode(String codeType, String rn) {
		
		ResCode rcode = null;
		Code code = null;
		int intNumber = 0;
		String finalNumber = "";
		
		if ("RES".equals(codeType) && "".equals(rn)) {
			rcode = rescodemapper.selectBytype(codeType);
			intNumber = Integer.parseInt(rcode.getNumber());
		} else {
			code =new Code();
			code.setRestaurantNumber(rn);
			code.setCodeType(codeType);
			code = codemapper.selectBytypeAndrn(code);
			intNumber = Integer.parseInt(code.getNumber());
		}
		
		String number = String.valueOf(intNumber);
		for (int i=0; i<6; i++) {
			number = number.length() < 6 ? "0" + number : number;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String date = format.format(new Date());
		
		if ("RES".equals(codeType)) {
			finalNumber = rcode.getCodeType() + "-" + date + "-" +number;
		} else {
			finalNumber = code.getCodeType() + "-" + date + "-" +number;
		}
		
		return finalNumber;
	}
	
	//更新编号
	@Override
	public void updateCode(String number, String codeType) {
		
		Code code = null;
		ResCode rcode = null;
		String string = "";
		
		if ("RES".equals(codeType)) {
			rcode = rescodemapper.selectBytype(codeType);
			string = rcode.getNumber();
		} else {
			code = new Code();
			code.setRestaurantNumber(number);
			code.setCodeType(codeType);
			code = codemapper.selectBytypeAndrn(code);
			string = code.getNumber();
		}

		int intNumber = Integer.parseInt(string);
		intNumber++;
		String snumber = String.valueOf(intNumber);
		for (int i=0; i<6; i++) {
			snumber = snumber.length() < 6 ? "0" + snumber : snumber;
		}
		
		if ("RES".equals(codeType)) {
			rcode.setNumber(snumber);
			rescodemapper.update(rcode);
		} else {
			code.setNumber(snumber);
			codemapper.updateBytype(code);
		}
	}

	//创建店铺对应的编号信息
	@Override
	public void createCode(String restaurantNumber, String codeType, String number) {
		Code code = new Code();
		code.setCodeType(codeType);
		code.setRestaurantNumber(restaurantNumber);
		code.setNumber(number);
		codemapper.createCode(code);
	}

}
