package com.jwt.JWT.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
	// Thong tin ho va ten
	@Id
	private String Fullname;
	
	// Thong tin phong ban
	private String department;

	// Thong tin so dien thoai
	private String phone;
	
	// Thong tin chuc vu
	private String position;
	
	// Thong tin ngay sinh
	private String birthday;
	
	// Thong tin ngay tham gia
	private String Startday;
	
	// Thong tin luong
	private int salary;
	
}
