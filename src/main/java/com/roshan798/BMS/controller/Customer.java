package com.roshan798.BMS.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Customer {

	@RequestMapping("/ping")
	public String ping() {
		return "Hello World";
	}
}
