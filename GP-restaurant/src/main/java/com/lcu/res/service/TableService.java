package com.lcu.res.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.lcu.res.po.PageBean;
import com.lcu.res.po.Table;

public interface TableService {

	void createTable(Table table);

	PageBean<Table> findByPage(int currentPage, int pageSize, HttpSession session);

	Table selectByTnAndRn(String tableNumber, String restaurantNumber);

	void updateTable(Table tableinfo);

	void deleteTable(Table tableinfo);

	List<Table> selectByRnAndSeat(Table table);

	void updateStatus(Table tableinfo);

}
