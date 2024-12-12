package com.roshan798.BMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@GetMapping("/")
	public String ping() {
		return "Hello World";
	}
}
