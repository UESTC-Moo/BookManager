package com.nowcoder.project.service;

import com.nowcoder.project.dao.UserDAO;
import com.nowcoder.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public int addUser(User user){
        return userDAO.addUser(user);
    }

    public User getUser(String email){
        return userDAO.selectByEmail(email);
    }

    public User getUSer(int uid){
        return userDAO.selectById(uid);
    }

    public User getUserByName(String name){
        return userDAO.selectByName(name);
    }

    public void updatePassWord(String password){
        userDAO.updatePassword(password);
    }
}
