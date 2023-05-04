package com.jwt.JWT.Project.service.Impl;

import com.jwt.JWT.Project.entity.Employee;
import com.jwt.JWT.Project.entity.User;
import com.jwt.JWT.Project.entity.UserRole;
import com.jwt.JWT.Project.repository.EmployeeRepository;
import com.jwt.JWT.Project.repository.UserRepository;
import com.jwt.JWT.Project.repository.UserRoleRepository;
import com.jwt.JWT.Project.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    // Thong tin user role dao
    @Autowired
    UserRoleRepository userRoleDao;

    @Autowired
    UserRepository userDao;

    @Autowired
    EmployeeRepository employeeDao;

    /**
     * Luu user role vao database
     *
     * @param thong tin user role
     */
    @Override
    public void save(UserRole userRole) {
        userRoleDao.save(userRole);
    }

    /**
     * Tim kiem tat ca entity trong user role
     *
     * @param thong tin user role
     */
    @Override
    public List<UserRole> findAll() {
        return userRoleDao.findAll();
    }

    /**
     * Tim kiem tat cac entity trong user role co role la admin hoac director
     */
    @Override
    public List<UserRole> findAllAdminOrDirector() {
        return userRoleDao.findAllAdminOrDirector();
    }

    @Override
    public void delete(Integer id) {
        // Xoa user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User temp = userDao.findUserByEmail(username);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = userDao.findById(id).get();

        if (!temp.getEmail().equals(user.getEmail())) {
            user.setDeleteday(timestamp.toString());
            user.setPersondelete(temp.getId());
            userDao.save(user);

            // Xoa employee
            List<Employee> listEmployee = user.getListEmployee();
            for (Employee e : listEmployee) {
                e.setDeleteday(timestamp.toString());
                e.setPersondelete(temp.getId());
                employeeDao.save(e);
            }
        } else {
            throw new RuntimeException();
        }
    }

}
