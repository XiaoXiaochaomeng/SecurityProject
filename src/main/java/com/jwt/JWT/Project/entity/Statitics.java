package com.jwt.JWT.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Statitic")
@NoArgsConstructor
@AllArgsConstructor
public class Statitics implements Serializable {
	
	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "OrderId")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "OrderDetailId")
	private OrderDetail OrderDetail;
	
	private long slOrder;
	
	private long slDoanhthu;

}
