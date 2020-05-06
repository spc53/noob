package com.lcu.res.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcu.res.dao.FoodMapper;
import com.lcu.res.po.Food;
import com.lcu.res.po.PageBean;
import com.lcu.res.po.User;

@Service
public class FoodServicelmpl implements FoodService {

	@Autowired
	FoodMapper foodmapper;
	
	@Override
	public void createfood(Food food) {
		foodmapper.createfood(food);
	}

	@Override
	public List<Food> selectAllByresname(String restaurantNumber) {
		return foodmapper.selectAllByresname(restaurantNumber);
	}

	@Override
	public Food selectByresAndfood(String foodNumber, String restaurantNumber) {
		
		Food food = new Food();
		food.setRestaurantNumber(restaurantNumber);
		food.setFoodNumber(foodNumber);
		
		return foodmapper.selectByresAndfood(food);
	}

	@Override
	public void deleteByresAndfood(Food food) {
		foodmapper.deleteByresAndfood(food);
	}

	@Override
	public void updateByresAndfood(Food food) {
		foodmapper.updateByresAndfood(food);
	}

	@Override
	public PageBean<Food> findByPage(int currentPage, int pageSize, HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		PageBean<Food> pageBean = new PageBean<>();
		User userInfo = (User)session.getAttribute("USERINFO");
		
		//当前页数
		pageBean.setCurrPage(currentPage);
		
		//每页显示的记录数
		pageBean.setPageSize(pageSize);
		
		//总记录数
		int totalCount = foodmapper.selectCount(userInfo.getRestaurantNumber());
		pageBean.setTotalCount(totalCount);
		
		//总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		
		map.put("restaurantNumber", userInfo.getRestaurantNumber());
		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		
		//每页显示的数据
		List<Food> lists = foodmapper.findByPage(map);
		pageBean.setLists(lists);
		
		return pageBean;
	}
	
}
