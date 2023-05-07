package com.jwt.JWT.Project.dto;

import com.jwt.JWT.Project.entity.Account;
import com.jwt.JWT.Project.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Account account;
	private Role role;
	private Boolean isEdit;
}