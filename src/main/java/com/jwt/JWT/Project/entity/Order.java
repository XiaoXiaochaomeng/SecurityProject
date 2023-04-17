package com.jwt.JWT.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    // Thong tin order id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    // Thong tin dia chi nguoi dung
    @ManyToOne
    @JoinColumn(name = "Address_Id")
    Address address;

    // Thong tin san pham
    @ManyToOne
    @JoinColumn(name = "Product_Id")
    Product product;

    // Thong tin so luong
    private int quality;

    // Thong tin ngay mua
    private String date;

    // Thong tin phuong thuc van chuyen
    private String method;

    // Thong tin trang thai van chuyen
    private String status;
}
