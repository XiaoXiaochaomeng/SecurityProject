package com.jwt.JWT.Project.service.Impl;

import com.jwt.JWT.Project.dto.ChangePassModel;
import com.jwt.JWT.Project.dto.InformationModel;
import com.jwt.JWT.Project.repository.UserRepository;
import com.jwt.JWT.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userDao;

    /**
     * Tim user bang email truyen vao
     *
     * @param username thong tin Email
     * @return User tim duoc
     */
    @Override
    public User findUserByEmail(String email) {
        // Tra ve User tim duoc
        return userDao.findUserByEmail(email);
    }

    /**
     * Luu user vao database
     *
     * @param user thong tin user
     */
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User create(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> findAllUserAnable() {
        return userDao.findAllUserAnable();
    }

    @Override
    public InformationModel getUserAccount() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findUserByEmail(username);

        InformationModel information = new InformationModel();

        information.setPassword(user.getPassword());
        information.setFullName(user.getFullname());
        information.setEmail(user.getEmail());
        information.setBirthday(user.getBirthday());
        information.setGender(user.getSex());
        information.setNews(user.getSubscribe());

        return information;
    }

    @Override
    public InformationModel update(InformationModel informationModel) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findUserByEmail(username);

        user.setFullname(informationModel.getFullName());
        user.setBirthday(informationModel.getBirthday());
        user.setSubscribe(informationModel.getNews());
        user.setSex(informationModel.getGender());

        userDao.save(user);

        return informationModel;
    }

    @Override
    public ChangePassModel updatePass(ChangePassModel changePassModel) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findUserByEmail(username);

        user.setPassword(changePassModel.getNewPass());

        userDao.save(user);

        return changePassModel;
    }

    @Override
    public User findById(Integer id) {
        // TODO Auto-generated method stub
        return userDao.findById(id).get();
    }

    @Override
    public InformationModel createUser(InformationModel informationModel) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        User user = new User();

        user.setEmail(informationModel.getEmail());
        user.setFullname(informationModel.getFullName());
        user.setBirthday(informationModel.getBirthday());
        user.setSubscribe(informationModel.getNews());
        user.setSex(informationModel.getGender());
        user.setPassword("1234567");

        user.setCreateday(timestamp.toString());

        userDao.save(user);

        return informationModel;
    }

    @Override
    public List<User> findAllUserNotRoleAdmin() {
        List<User> listUser = userDao.findAllUserNotRoleAdmin();
        return listUser;
    }

    @Override
    public void deleteUser(Integer id) {
        // Xoa user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User temp = userDao.findUserByEmail(username);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = userDao.findById(id).get();

        user.setDeleteday(timestamp.toString());
        user.setPersondelete(temp.getId());
        userDao.save(user);
    }

    @Override
    public InformationModel getOneUserById(Integer id) {
        User user = userDao.findById(id).get();
        InformationModel information = new InformationModel();

        information.setFullName(user.getFullname());
        information.setEmail(user.getEmail());
        information.setGender(user.getSex());
        information.setNews(user.getSubscribe());
        information.setBirthday(user.getBirthday());

        //System.out.println("this is username:" + user.getFullname());

        return information;
    }

    @Override
    public InformationModel updateUser(InformationModel informationModel, Integer id) {

        User user = userDao.findById(id).get();

        //user.setEmail(informationModel.getEmail());
        user.setFullname(informationModel.getFullName());
        user.setBirthday(informationModel.getBirthday());
        user.setSubscribe(informationModel.getNews());
        user.setSex(informationModel.getGender());

        userDao.save(user);

        return informationModel;
    }

    @Override
    public List<User> getListUserEnableSubscribe() {
        return userDao.getListUserEnableSubscribe();
    }
}
