package com.lcu.res.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lcu.res.po.Food;
import com.lcu.res.po.PageBean;
import com.lcu.res.po.User;
import com.lcu.res.service.CodeService;
import com.lcu.res.service.FoodService;
import com.lcu.res.service.UtilService;

@Controller
@RequestMapping("/food")
public class FoodController {

	@Autowired
	FoodService foodservice;
	
	@Autowired
	CodeService codeservice;
	
	@Autowired
	UtilService utilservice;
	
	@RequestMapping("/{path}")
	public String path(@PathVariable String path) {
		if ("f_create".equals(path)) {
			path = "food/" + path;
		}
		return path;
	}
	
	//新建餐饮
	@RequestMapping("/createfood")
	public String createfood(Food food, Model model, String salestatus, String sunitPrice, HttpSession session, HttpServletRequest request, MultipartFile imgUpload) {
		
		//获取店编号
		User user = (User)session.getAttribute("USERINFO");
		String restaurantNumber = user.getRestaurantNumber();
		food.setRestaurantNumber(restaurantNumber);
		
		//生成餐饮编号
		String codeType = "FD";
		String foodNumber = codeservice.createCode(codeType, restaurantNumber);
		food.setFoodNumber(foodNumber);
		
		//上传图片
		String newImgname = utilservice.uploadImg(request, imgUpload);
		food.setPictureName(newImgname);
		
		//出售状态
		if ("sale_no".equals(salestatus)) {
			food.setSaleStatus(1);
		} else if ("saled".equals(salestatus)) {
			food.setSaleStatus(2);
		} else {
			return "";
		}
		
		//单价和打折
		BigDecimal unitPrice = new BigDecimal(sunitPrice);
		unitPrice = unitPrice.setScale(1, BigDecimal.ROUND_HALF_UP);
		food.setUnitPrice(unitPrice);
		
		//新建餐饮
		foodservice.createfood(food);
		
		//更新编号表
		codeservice.updateCode(restaurantNumber, codeType);
		
		return "food/f_create";
	}
	
	//餐饮一览,分页显示
	@RequestMapping("/showfood")
	public String showfood(@RequestParam(value="currentPage", defaultValue="1", required=false)int currentPage, Model model, HttpSession session) {
		
		PageBean<Food> pageBean = foodservice.findByPage(currentPage, 5, session);
		if (pageBean.getTotalCount() != 0) {
			model.addAttribute("PAGEMSG", pageBean);
		}
		
		return "food/f_update";
	}
	
	//餐饮一览,分页显示,用于创建订单
	@RequestMapping("/showfoodFororder")
	public String showfoodFororder(@RequestParam(value="currentPage", defaultValue="1", required=false)int currentPage, Model model, HttpSession session) {
		
		PageBean<Food> pageBean = foodservice.findByPage(currentPage, 12, session);
		if (pageBean.getTotalCount() != 0) {
			model.addAttribute("PAGEMSG", pageBean);
		}
		
		return "food/f_show_for_order";
	}
	
	//删除餐饮
	@RequestMapping("/deletefood")
	public String deletefood(HttpServletRequest request, String foodNumber, String restaurantNumber) {
		
		Food food = foodservice.selectByresAndfood(foodNumber, restaurantNumber);
		if (food == null) {
			return "";  //错误画面
		}
		
		//删除图片
		utilservice.deleteImg(request, food);
		
		//删除数据库数据
		foodservice.deleteByresAndfood(food);
		
		return "redirect:showfood";
	}
	
	//跳转到修改画面
	@RequestMapping("/foodinfo")
	public String foodinfo(String foodNumber, String restaurantNumber, HttpSession session) {
	
		Food food = foodservice.selectByresAndfood(foodNumber, restaurantNumber);
		if (food == null) {
			return "";  //错误画面
		}
		
		session.setAttribute("FOODINFO", food);
		return "food/f_info";
	}
	
	//修改餐饮
	@RequestMapping("/updatefood")
	public String updatefood(Food food, Model model, String salestatus, String sunitPrice, HttpSession session, HttpServletRequest request, MultipartFile imgUpload) {
		
		Food foodinfo = foodservice.selectByresAndfood(food.getFoodNumber(), food.getRestaurantNumber());
		if (foodinfo == null) {
			return "";  //错误画面
		}
		
		//出售状态
		if ("sale_no".equals(salestatus)) {
			food.setSaleStatus(1);
		} else if ("saled".equals(salestatus)) {
			food.setSaleStatus(2);
		} else {
			return "";
		}
		
		//单价
		BigDecimal unitPrice = new BigDecimal(sunitPrice);
		unitPrice = unitPrice.setScale(1, BigDecimal.ROUND_HALF_UP);
		food.setUnitPrice(unitPrice);
		
		//图片
		if (imgUpload.getSize() > 0) {
			//上传图片
			String newImgname = utilservice.uploadImg(request, imgUpload);
			food.setPictureName(newImgname);
		} 
		
		//更新
		foodservice.updateByresAndfood(food);
		
		return "redirect:showfood";
	}
	
}
