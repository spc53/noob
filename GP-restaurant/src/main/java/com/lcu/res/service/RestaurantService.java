package com.lcu.res.service;

import com.lcu.res.po.Restaurant;

public interface RestaurantService {

	void createShop(Restaurant res);

	Restaurant selectByNum(String restaurantNumber);

}
