package com.jwt.JWT.Project.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "FeedBacks")
public class Feedback implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;
	private String description;
	@ManyToOne
	@JoinColumn(name = "Username")
	private Account account;
}
