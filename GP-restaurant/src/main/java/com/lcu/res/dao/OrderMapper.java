package com.lcu.res.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import com.lcu.res.po.Order;

@Repository
@Mapper
public interface OrderMapper {

	void saveOrder(Order order);

	int selectCount(HashMap<String, Object> map);

	List<Order> findByPage(HashMap<String, Object> map);

	Order selectByonAndrn(Order order);

	void deleteOrder(Order order);

}
