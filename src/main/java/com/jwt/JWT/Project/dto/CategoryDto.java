package com.jwt.JWT.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long categoryId;
	@NotEmpty
	private String name;
	private Boolean isEdit = false;
}
