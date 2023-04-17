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
@Table(name = "Roles")
public class Role implements Serializable {
    // Thong tin Role Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Thong tin Role Name
    private String name;

    // Lay danh sach User Role
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<UserRole> listUserRole;
}
