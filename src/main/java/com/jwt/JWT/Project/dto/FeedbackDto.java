package com.jwt.JWT.Project.dto;

import com.jwt.JWT.Project.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long feedbackId;
	private String description;
	private Account account;
}
