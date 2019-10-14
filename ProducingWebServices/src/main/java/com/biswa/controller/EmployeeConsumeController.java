package com.biswa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswa.service.EmployeeConsumeService;

@RestController
public class EmployeeConsumeController {
	@Autowired
	EmployeeConsumeService employeeConsumeService;
	@RequestMapping("/consumeData")
	public ResponseEntity<String> consumeData() {
		return employeeConsumeService.consumeJsonData();
	}
}
