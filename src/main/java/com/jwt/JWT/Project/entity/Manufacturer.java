package com.jwt.JWT.Project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Manufactures")
public class Manufacturer implements Serializable {
    // Thong tin category id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Thong tin ten category
    private String name;

    // Thong tin hinh dai dien
    private String logo;

    // Thong tin banner
    private String banner;

    // Thong tin mo ta
    private String description;

    // Thong tin ngay tao
    private String Createday;

    // Thong tin ma nguoi tao
    private int Personcreate;

    // Thong tin ngay xoa
    private String Deleteday;

    // Thong tin nguoi xoa
    private int Persondelete;

    // Thong tin ngay cap nhat
    private String Updateday;

    // Thong tin ma nguoi cap nhat
    private int Personupdate;

    // Danh sach san pham
    @JsonIgnore
    @OneToMany(mappedBy = "manufacturer")
    List<Product> listProduct;
}
