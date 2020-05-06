package com.lcu.res.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lcu.res.po.Food;

@Repository
@Mapper
public interface FoodMapper {

	void createfood(Food food);

	List<Food> selectAllByresname(String restaurantNumber);

	Food selectByresAndfood(Food food);

	void deleteByresAndfood(Food food);

	void updateByresAndfood(Food food);

	int selectCount(String restaurantNumber);

	List<Food> findByPage(HashMap<String, Object> map);

}
