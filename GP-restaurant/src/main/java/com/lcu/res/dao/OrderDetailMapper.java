package com.lcu.res.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lcu.res.po.OrderDetail;

@Repository
@Mapper
public interface OrderDetailMapper {

	void saveOrderDetail(OrderDetail value);

	List<OrderDetail> selectodByonAndrn(OrderDetail od);

	void deleteOrderD(OrderDetail od);
	
}
