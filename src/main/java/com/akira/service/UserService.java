package com.akira.service;

import com.akira.model.User;
import com.akira.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 获取所有用户列表
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * 根据id获取用户详情
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * 添加新用户
     */
    public void addUser(User user) {
        userRepository.save(user);
    }

    /**
     * 修改用户信息
     */
    public void updateUser(Long id, User user) {
        User oldUser = getUserById(id);
        if (oldUser != null) {
            oldUser.setUsername(user.getUsername());
            oldUser.setPassword(user.getPassword());
            oldUser.setEmail(user.getEmail());
            userRepository.save(oldUser);
        }
    }

    /**
     * 删除用户
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
