package com.roshan798.BMS.dto;

import lombok.Data;

@Data
public class LoginRequest {
	private long employeeId;
	private String password;
}
