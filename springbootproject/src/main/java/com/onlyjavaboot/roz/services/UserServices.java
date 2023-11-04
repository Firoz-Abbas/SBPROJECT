package com.onlyjavaboot.roz.services;

import com.onlyjavaboot.roz.intities.User;

import java.util.List;

public interface UserServices {
    public List<User> getUseres();
    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(int parseInt);
}
