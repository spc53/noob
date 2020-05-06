package com.lcu.res.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcu.res.dao.RestaurantMapper;
import com.lcu.res.po.Restaurant;

@Service
public class RestaurantServicelmpl implements RestaurantService {

	@Autowired
	RestaurantMapper resmapper;
	
	@Override
	public void createShop(Restaurant res) {
		resmapper.createShop(res);
	}

	@Override
	public Restaurant selectByNum(String restaurantNumber) {
		return resmapper.selectByNum(restaurantNumber);
	}
	
}
