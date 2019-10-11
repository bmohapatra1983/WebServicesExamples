package com.biswa.controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswa.dao.EmployeeDAO;
import com.biswa.dao.EmployeeDAO.StockDetails;

@RestController
public class StockController {
	@Autowired
	EmployeeDAO employeeDAO;
	@RequestMapping("/stocks")
	public LinkedList<StockDetails> getStockDetails() {
		System.out.println("-----------------@RequestMapping(\"/stocks\")");
		return employeeDAO.getStockDetails();
		//return "stock details..";
	}
}
