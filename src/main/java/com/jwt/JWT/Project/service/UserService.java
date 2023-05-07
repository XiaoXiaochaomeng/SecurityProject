package com.jwt.JWT.Project.service;

import com.jwt.JWT.Project.dto.ChangePassModel;
import com.jwt.JWT.Project.dto.InformationModel;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);

    void save(User user);

    List<User> findAll();

    User create(User user);

    List<User> findAllUserAnable();

    InformationModel getUserAccount();

    InformationModel update(InformationModel informationModel);

    ChangePassModel updatePass(ChangePassModel changePassModel);

    User findById(Integer id);

    InformationModel createUser(InformationModel informationModel);

    List<User> findAllUserNotRoleAdmin();

    void deleteUser(Integer id);

    InformationModel getOneUserById(Integer id);

    InformationModel updateUser(InformationModel informationModel, Integer id);

    List<User> getListUserEnableSubscribe();
}
