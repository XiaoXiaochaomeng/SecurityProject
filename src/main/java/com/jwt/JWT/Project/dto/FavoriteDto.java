package com.jwt.JWT.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long favoriteId;
	private String username;
	private Long productId;
}
