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
@Table(name = "Users")
public class User implements Serializable {
    // Thong tin user id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Thong tin email
    private String email;

    // Thong tin password
    private String password;

    // Thong tin fullname
    private String Fullname;

    // Thong tin gioi tinh
    private int sex;

    // Thong tin ngay sinh nhat
    private String birthday;

    // Thong tin dang ky nhan ban tin
    private int subscribe;

    // Thong tin ngay tao
    private String Createday;

    // Thong tin ngay xoa
    private String Deleteday;

    // Thong tin nguoi xoa
    private int Persondelete;

    // Danh sach User Role
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<UserRole> listUserRole;

    // Danh sach Employee
    // @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    List<Employee> listEmployee;

    // Danh sach dia chi
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    List<Address> listAddress;
}
