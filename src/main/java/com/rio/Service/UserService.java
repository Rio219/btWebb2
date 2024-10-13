package com.rio.Service;

import java.util.List;

import com.rio.Dao.UserDao;
import com.rio.Idao.IUserDao;
import com.rio.Iservices.IUserService;
import com.rio.entity.User;

public class UserService implements IUserService {

    IUserDao userDao = new UserDao();

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int userId) throws Exception {
        userDao.delete(userId);
    }

    @Override
    public User findById(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
