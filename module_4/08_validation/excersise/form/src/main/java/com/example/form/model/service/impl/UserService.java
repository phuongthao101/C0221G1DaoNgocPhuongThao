package com.example.form.model.service.impl;

import com.example.form.model.entity.User;
import com.example.form.model.repository.IUserRepository;
import com.example.form.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

}
