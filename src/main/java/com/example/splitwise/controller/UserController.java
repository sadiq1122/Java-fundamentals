package com.example.splitwise.controller;

import com.example.splitwise.entity.User;
import com.example.splitwise.models.UserDTO;
import com.example.splitwise.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Map<String, Long>> createUser(@RequestBody @Valid UserDTO user) throws Exception {
        return ResponseEntity.ok().body(userService.creteUser(user));
    }

}
