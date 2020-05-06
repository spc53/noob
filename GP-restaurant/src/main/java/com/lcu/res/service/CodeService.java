package com.lcu.res.service;

public interface CodeService {

	String createCode(String codeType, String rn);

	void updateCode(String number, String codeType);

	void createCode(String restaurantNumber, String codeType, String number);

}
