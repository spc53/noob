package com.lcu.res.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lcu.res.po.Restaurant;

@Repository
@Mapper
public interface RestaurantMapper {

	int insert(Restaurant res);

	void createShop(Restaurant res);

	Restaurant selectByNum(String restaurantNumber);
	
}
