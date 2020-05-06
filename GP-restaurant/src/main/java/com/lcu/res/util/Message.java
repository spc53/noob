package com.lcu.res.util;

public class Message {
	
	//成功
	public static final String SUCCESS 				= "SUCCESS";
	
	//不能为空
	public static final String USERNAME_EMPTY_ERROR 			= "用户名不能为空";
	public static final String PASSWORD_EMPTY_ERROR 			= "密码不能为空";
	public static final String RESCODE_EMPTY_ERROR 				= "店铺编号不能为空"; 
	public static final String TELEPHONE_EMPTY_ERROR 			= "手机号不能为空"; 
	public static final String ACTUALNAME_EMPTY_ERROR 			= "真实姓名不能为空"; 
	public static final String RESTAURANTNAME_EMPTY_ERROR 		= "店铺名不能为空"; 
	public static final String RESTAURANTADDRESS_EMPTY_ERROR 	= "开店地址不能为空"; 
	public static final String RESTAURANTMANAGER_EMPTY_ERROR 	= "店长不能为空";
	
	//长度限制
	public static final String USERNAME_LENGTH_ERROR 			= "用户名长度不能超过20个字符";
	public static final String PASSWORD_LENGTH_ERROR 			= "密码长度为8~14个字符";
	public static final String RESCODE_LENGTH_ERROR 			= "店铺编号长度不能超过20个字符"; 
	public static final String TELEPHONE_LENGTH_ERROR 			= "手机号长度不能超过11个字符"; 
	public static final String ACTUALNAME_LENGTH_ERROR 			= "真实姓名长度不能超过10个字符"; 
	public static final String RESTAURANTNAME_LENGTH_ERROR 		= "店铺名长度不能超过30个字符"; 
	public static final String RESTAURANTADDRESS_LENGTH_ERROR 	= "开店地址长度不能超过100个字符"; 
	public static final String RESTAURANTMANAGER_LENGTH_ERROR 	= "店长长度不能超过10个字符";
	
	//格式限制
	public static final String PASSWORD_FORMAT_ERROR 	= "密码格式不对"; 
	public static final String TELEPHONE_FORMAT_ERROR 	= "手机号格式不对";
	
	//异常错误
	public static final String EXCPTION_ERROR 	= "登录或注册异常错误";
	
}
