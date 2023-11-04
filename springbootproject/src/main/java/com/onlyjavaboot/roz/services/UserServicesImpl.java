package com.onlyjavaboot.roz.services;

import com.onlyjavaboot.roz.dao.UserDaoRepository;
import com.onlyjavaboot.roz.intities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserDaoRepository userDaoRepository;
    public UserServicesImpl(){}

    @Override
    public List<User> getUseres() {
        return userDaoRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        userDaoRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userDaoRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(int deleteUser) {
        User uintity=userDaoRepository.getOne(deleteUser);
        userDaoRepository.delete(uintity);
    }
}
