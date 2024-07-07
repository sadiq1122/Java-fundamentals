package com.example.splitwise.service.impl;

import com.example.splitwise.entity.User;
import com.example.splitwise.models.UserDTO;
import com.example.splitwise.repository.UserRepository;
import com.example.splitwise.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getReferenceById(userId);
    }

    @Override
    public Map<String, Long> creteUser(UserDTO user) throws Exception{


        List<User> existingUser = userRepository.findAllByEmail(user.getEmail());
        if (!CollectionUtils.isEmpty(existingUser))
            throw new Exception("User already exists!");

        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNo(user.getPhoneNo());
        newUser.setCreatedAt(Calendar.getInstance().getTime());
        newUser.setUpdatedBy(user.getEmail());
        newUser.setModifiedAt(new Date());

        User save = userRepository.save(newUser);
        return Map.of("userId", save.getUserID());
    }

}
