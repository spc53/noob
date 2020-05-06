package com.lcu.res.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcu.res.po.Restaurant;
import com.lcu.res.po.User;
import com.lcu.res.service.CodeService;
import com.lcu.res.service.RestaurantService;
import com.lcu.res.service.UserService;
import com.lcu.res.service.UtilService;

@Controller
@RequestMapping("/res")
public class RestaurantController {

	@Autowired
	UtilService utilservice;
	
	@Autowired
	RestaurantService resservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	CodeService codeservice;
	
	@RequestMapping("/{path}")
	public String path(@PathVariable String path) {
		if ("register_shop".equals(path)) {
			path = "register/" + path;
		}
		return path;
	}
	
	//注册店铺
	@RequestMapping("/shopRegister")
	public String shopRegister(User user, Restaurant res, Model model) {
		
		//输入框各种判断
		String flg = "shopRegister";
		String msg = "";
		msg = utilservice.shopJudgment(res);
		if (msg != "SUCCESS") {
			model.addAttribute("SHOPREGISTERERROR", msg);
			return "register/register_shop";
		} else {
			msg = utilservice.userJudgment(user, flg);
			if (msg != "SUCCESS") {
				model.addAttribute("SHOPREGISTERERROR", msg);
				return "register/register_shop";
			}
		}
		
		//生成店编号
		String codeType = "RES";
		String restaurantNumber = codeservice.createCode(codeType, "");
		res.setRestaurantNumber(restaurantNumber);
		
		//店铺注册
		resservice.createShop(res);
		
		//创建店铺对应的编号信息
		String ord = "000001";
		String fd = "000001";
		String ordType = "ORD";
		String fdType = "FD";
		codeservice.createCode(restaurantNumber, ordType, ord);
		codeservice.createCode(restaurantNumber, fdType, fd);
		
		//更新编号表
		codeservice.updateCode(restaurantNumber, codeType);
		
		//店长注册
		user.setRestaurantNumber(restaurantNumber);
		user.setAuthority(1);
		user.setActualName(res.getRestaurantManager());
		userservice.createUser(user);
		
		return "../login";
	}
	
}
