package com.lcu.res.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcu.res.po.Restaurant;
import com.lcu.res.po.User;
import com.lcu.res.service.RestaurantService;
import com.lcu.res.service.UserService;
import com.lcu.res.service.UtilService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;

	@Autowired
	UtilService utilservice;
	
	@Autowired
	RestaurantService resservice;
	
	@RequestMapping("/{path}")
	public String path(@PathVariable String path) {
		if ("login".equals(path)) {
			path = "../" + path;
		}
		
		if ("register_emp".equals(path)) {
			path = "register/" + path;
		}
		
		if ("emptymain".equals(path)) {
			path = "main/" + path;
		}
		
		return path;
	}
	
	//用户登录验证
	@RequestMapping("/loginCheck")
	public String loginCheck(User user,String maintype, Model model, HttpSession session) {
		
		/*//判断传参是否正常
		if (user == null) {
			model.addAttribute("PARAMERROR", "出现异常");
			return "../login";
		}*/
		
		//输入框的各种判断
		String flg = "login";
		String msg = utilservice.userJudgment(user, flg);
		if (msg != "SUCCESS") {
			model.addAttribute("LOGINERROR",msg);
			return "../login";
		}
		
		//用户验证
		User userInfo = userservice.loginCheck(user);
		if (userInfo != null) {
			Restaurant res = resservice.selectByNum(userInfo.getRestaurantNumber());
			session.setAttribute("RESINFO", res);
			
			session.setAttribute("USERINFO", userInfo);
			if ("Front_desk".equals(maintype)) {
				return "main/main_front_desk";
			} else if ("Back_kitchen".equals(maintype)) {
				return "redirect:../order/showBackOrder";
			} else {
				//错误画面
				return "";
			}
		} else {
			model.addAttribute("ERROR", "用户名或密码不对");
			return "../login";
		}
	
	}
	
	//安全退出
	@RequestMapping("/retreatSafely")
	public String retreatSafely(HttpSession session) {
		session.invalidate();
		return "../login";
	}
	
	//员工注册
	@RequestMapping("/empRegister")
	public String empRegister(User user,String restaurantNumber, Model model) {
			
		//输入框的各种判断
		String flg = "userRegister";
		String msg = utilservice.userJudgment(user, flg);
		if (msg != "SUCCESS") {
			model.addAttribute("RESGISTERERROR",msg);
			return "register/register_emp";
		}
		
		//用户注册
		user.setRestaurantNumber(restaurantNumber);
		user.setAuthority(2);
		userservice.createUser(user);
		return "../login";
	
	}
	
	//更新用户信息
	@RequestMapping("/updateUserInfo")
	@ResponseBody
	public String updateUserInfo(User user, HttpSession session) {
		System.out.println("====更新用户信息====");
		int count = userservice.updateUserInfo(user);		
		if (count == 1) {
			User userInfo = userservice.selectByUserName(user.getUserName());
			session.setAttribute("USERINFO", userInfo);
			return "200";
		} else {
			return "400";
		}
	}
	
	//修改密码
	@RequestMapping("/updatePw")
	@ResponseBody
	public String updatePw(User user, String orgPassword, String aPassword) {
		String newPw = user.getPassword();
		//验证原始密码
		String pw = userservice.selectPwByName(user.getUserName());
		if (pw.equals(orgPassword) == false) {
			return "401";
		}
		
		//再次确认密码
		if (aPassword.equals(newPw) == false) {
			return "402";
		}
		
		//更新密码
		int count = userservice.updatePw(user);		
		if (count == 1) {
			return "200";
		} else {
			return "400";
		}
	}
	
}
