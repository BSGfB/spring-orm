package com.test.orm.service;

import com.test.orm.dao.RoleDao;
import com.test.orm.dao.UserDao;
import com.test.orm.model.Role;
import com.test.orm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    final UserDao userDao;
    final RoleDao roleDao;

    @Autowired
    public UserService(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public List<User> gatAll() {
        return userDao.findAll();
    }

    public User getById(Long id) {
        return userDao.getOne(id);
    }

    public Role saveRole(Role role) {
        return roleDao.save(role);
    }

    public Role findOne(long id) {
        return roleDao.findById(id).get();
    }
}
