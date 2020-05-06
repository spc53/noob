package com.lcu.res.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.lcu.res.po.Food;
import com.lcu.res.po.PageBean;

public interface FoodService {

	void createfood(Food food);

	List<Food> selectAllByresname(String restaurantNumber);

	Food selectByresAndfood(String foodNumber, String restaurantNumber);

	void deleteByresAndfood(Food food);

	void updateByresAndfood(Food food);

	PageBean<Food> findByPage(int currentPage, int pageSize, HttpSession session);

}
