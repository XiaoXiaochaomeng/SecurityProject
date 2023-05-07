package com.jwt.JWT.Project.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "favorites")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long favoriteId;
	private String username;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
}
