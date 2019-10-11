package com.biswa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswa.service.EmployeeConsumeService;

@RestController
/* @Component */
public class EmployeeConsumeController {
	@Autowired
	EmployeeConsumeService employeeConsumeService;
	public static final String REST_URL = "http://localhost:8088/RESTApi/getAllEmployee";

	@RequestMapping("/consumeData")
	public ResponseEntity<String> consumeData() {
		return employeeConsumeService.consumeJsonData();
	}
}
