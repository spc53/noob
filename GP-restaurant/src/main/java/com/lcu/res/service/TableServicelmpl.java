package com.lcu.res.service;

import java.util.HashMap;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcu.res.dao.TableMapper;
import com.lcu.res.po.PageBean;
import com.lcu.res.po.Table;
import com.lcu.res.po.User;

@Service
public class TableServicelmpl implements TableService {

	@Autowired
	TableMapper tablemapper;
	
	@Override
	public void createTable(Table table) {
		tablemapper.createTable(table);
	}

	@Override
	public PageBean<Table> findByPage(int currentPage, int pageSize, HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		PageBean<Table> pageBean = new PageBean<>();
		User userInfo = (User)session.getAttribute("USERINFO");
		
		//当前页数
		pageBean.setCurrPage(currentPage);
		
		//每页显示的记录数
		pageBean.setPageSize(pageSize);
		
		//总记录数
		int totalCount = tablemapper.selectCount(userInfo.getRestaurantNumber());
		pageBean.setTotalCount(totalCount);
		
		//总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		
		map.put("restaurantNumber", userInfo.getRestaurantNumber());
		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		
		//每页显示的数据
		List<Table> lists = tablemapper.findByPage(map);
		pageBean.setLists(lists);
		
		return pageBean;
	}

	@Override
	public Table selectByTnAndRn(String tableNumber, String restaurantNumber) {
		Table table = new Table();
		table.setRestaurantNumber(restaurantNumber);
		table.setTableNumber(tableNumber);
		return tablemapper.selectByTnAndRn(table);
	}

	@Override
	public void updateTable(Table tableinfo) {
		tablemapper.updateTable(tableinfo);
	}

	@Override
	public void deleteTable(Table tableinfo) {
		tablemapper.deleteTable(tableinfo);
	}

	@Override
	public List<Table> selectByRnAndSeat(Table table) {
		return tablemapper.selectByRnAndSeat(table);
	}

	@Override
	public void updateStatus(Table tableinfo) {
		tablemapper.updateStatus(tableinfo);
	}

}
