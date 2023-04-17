package com.jwt.JWT.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassModel {
    private String oldPass;
    private String newPass;
    private String confirmPass;
}
