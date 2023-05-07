package com.jwt.JWT.Project.dto;

import com.jwt.JWT.Project.entity.Order;
import com.jwt.JWT.Project.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long orderDetailId;
    private Order order;
    private Product product;
    private Integer price;
    private Integer discount;
    private String status;
    private Integer quantity;
    private String discription;
    private Boolean isEdit;
}
