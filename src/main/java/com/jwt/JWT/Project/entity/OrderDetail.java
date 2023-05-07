package com.jwt.JWT.Project.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;
    @ManyToOne
    @JoinColumn(name = "Orderid")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "Productid")
    private Product product;
    private Integer price;
    private Integer discount;
    private Integer quantity;
    private String discription;
    private Integer amount;

}
