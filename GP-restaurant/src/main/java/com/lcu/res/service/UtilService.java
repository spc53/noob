package com.lcu.res.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.lcu.res.po.Food;
import com.lcu.res.po.Restaurant;
import com.lcu.res.po.User;

public interface UtilService {

	String userJudgment(User user, String flg);
	
	String shopJudgment(Restaurant res);

	String uploadImg(HttpServletRequest request, MultipartFile myfile);

	void deleteImg(HttpServletRequest request, Food food);
	
}
