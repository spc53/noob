package com.lcu.res.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcu.res.po.PageBean;
import com.lcu.res.po.Table;
import com.lcu.res.po.User;
import com.lcu.res.service.TableService;

@Controller
@RequestMapping("/table")
public class TableController {

	@Autowired
	TableService tableservice;
	
	@RequestMapping("/{path}")
	public String path(@PathVariable String path) {
		if ("t_create".equals(path)) {
			path = "table/" + path;
		}
		return path;
	}
	
	//创建餐桌
	@RequestMapping("/createTable")
	public String createTable(Table table, String seatNum, HttpSession session) {
		
		//店编号
		User userinfo = (User)session.getAttribute("USERINFO");
		table.setRestaurantNumber(userinfo.getRestaurantNumber());
		
		//状态
		table.setStatus(1);
		
		//座位数
		int sn = Integer.parseInt(seatNum);
		table.setSeatNum(sn);
		
		//被占用的座位数
		table.setOccupySeatNum(0);
		
		//空座位数
		table.setEmptySeatNum(table.getSeatNum());
		
		//创建
		tableservice.createTable(table);
		
		return "table/t_create";
	}
	
	//跳转到一览画面
	@RequestMapping("/showTable")
	public String showTable(@RequestParam(value="currentPage", defaultValue="1", required=false)int currentPage, Model model, HttpSession session) {
		PageBean<Table> pageBean = tableservice.findByPage(currentPage, 5, session);
		if (pageBean.getTotalCount() != 0) {
			model.addAttribute("TABLEPAGEMSG", pageBean);
		}
		return "table/t_update";
	}
	
	//查看餐桌状态
	@RequestMapping("/showTableForStatus")
	public String showTableForStatus(@RequestParam(value="currentPage", defaultValue="1", required=false)int currentPage, Model model, HttpSession session) {
		PageBean<Table> pageBean = tableservice.findByPage(currentPage, 12, session);
		if (pageBean.getTotalCount() != 0) {
			model.addAttribute("TABLEPAGEMSG", pageBean);
		}
		return "table/t_show_for_status";
	}
	
	//跳转到修改画面
	@RequestMapping("/tableinfo")
	public String tableinfo(String tableNumber, String restaurantNumber, Model model) {
		Table tableinfo = tableservice.selectByTnAndRn(tableNumber, restaurantNumber);
		if (tableinfo == null) {
			return "";
		}
		model.addAttribute("TABLEINFO", tableinfo);
		return "table/t_info";
	}
	
	//修改餐桌信息
	@RequestMapping("/updateTable")
	public String updateTable(String restaurantNumber,String tableNumber,String seatNum) {
		Table tableinfo = tableservice.selectByTnAndRn(tableNumber, restaurantNumber);
		if (tableinfo == null) {
			return "";
		}
		
		int sn = Integer.parseInt(seatNum);
		if (sn < tableinfo.getOccupySeatNum()) {
			return "";//座位数小于现在的被占用的座位数
		}
		
		tableinfo.setSeatNum(sn);
		tableinfo.setEmptySeatNum(sn - tableinfo.getOccupySeatNum());
		tableservice.updateTable(tableinfo);
		return "redirect:showTable";
	}
	
	//删除餐桌信息
	@RequestMapping("/deletetable")
	public String deletetable(String restaurantNumber,String tableNumber) {
		Table tableinfo = tableservice.selectByTnAndRn(tableNumber, restaurantNumber);
		if (tableinfo == null) {
			return "";
		}
		tableservice.deleteTable(tableinfo);
		return "redirect:showTable";
	}
	
	//生成订单时选择餐桌
	@RequestMapping("/selectTable")
	public String selectTable(HttpSession session, Model model, String occupySeatNum) {
		User userInfo = (User)session.getAttribute("USERINFO");
		Table table = new Table();
		table.setRestaurantNumber(userInfo.getRestaurantNumber());
		if (occupySeatNum == "" || occupySeatNum == null) {
			table.setOccupySeatNum(0);
		} else {
			int seat = Integer.parseInt(occupySeatNum);
			table.setOccupySeatNum(seat);
			model.addAttribute("OSEATNUM", occupySeatNum);
		}
		
		List<Table> lists = tableservice.selectByRnAndSeat(table);
		model.addAttribute("TABLELIST", lists);
		return "order/select_table";
	}
	
	//更新餐桌状态
	@RequestMapping("/updateStatus")
	public String updateStatus(String restaurantNumber, String tableNumber, String peopleNum, Model model) {
		Table tableinfo = tableservice.selectByTnAndRn(tableNumber, restaurantNumber);
		int os = tableinfo.getOccupySeatNum();
		int es = tableinfo.getEmptySeatNum();
		int pu = Integer.parseInt(peopleNum);
		os += pu;
		es -= pu;
		if (os == tableinfo.getSeatNum()) {
			tableinfo.setStatus(2);
		}
		tableinfo.setOccupySeatNum(os);
		tableinfo.setEmptySeatNum(es);
		tableservice.updateStatus(tableinfo);
		model.addAttribute("TABLENUMBER", tableNumber);
		model.addAttribute("POPNUM", peopleNum);
		return "order/o_cart";
	}
	
}
