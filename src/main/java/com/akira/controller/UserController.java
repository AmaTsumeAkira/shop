package com.akira.controller;

import com.akira.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.akira.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取所有用户列表
     */
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * 根据id获取用户详情
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    /**
     * 添加新用户
     */
    @PostMapping("")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
