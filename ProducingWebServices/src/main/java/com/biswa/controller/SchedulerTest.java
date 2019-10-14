package com.biswa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerTest {
	@Scheduled(fixedRate = 5000)
	@RequestMapping("/getData")
	public String showData() {
		System.out.println("Calling GetData()-------------");
		final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println("The time is now {}-"+ dateFormat.format(new Date()));
		return "Hello";
	}
}
