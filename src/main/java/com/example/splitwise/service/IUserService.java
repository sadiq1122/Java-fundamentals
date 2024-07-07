package com.example.splitwise.service;

import com.example.splitwise.entity.User;
import com.example.splitwise.models.UserDTO;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    Map<String, Long> creteUser(UserDTO user) throws Exception;
}
