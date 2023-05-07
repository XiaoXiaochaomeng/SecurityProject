package com.jwt.JWT.Project.dto;

import com.jwt.JWT.Project.entity.Account;
import com.jwt.JWT.Project.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long commentId;
	private Account account;
	private Product product;
	private String description;
	private Boolean isEdit;

}
