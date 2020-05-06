package com.lcu.res.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lcu.res.po.Table;

@Repository
@Mapper
public interface TableMapper {

	void createTable(Table table);

	int selectCount(String restaurantNumber);

	List<Table> findByPage(HashMap<String, Object> map);

	Table selectByTnAndRn(Table table);

	void updateTable(Table tableinfo);

	void deleteTable(Table tableinfo);

	List<Table> selectByRnAndSeat(Table table);

	void updateStatus(Table tableinfo);

}
