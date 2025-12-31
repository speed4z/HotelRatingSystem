package com.speed.user.service.services;

import com.speed.user.service.entities.User;
import com.speed.user.service.exeptions.ResourceNotFoundException;
import com.speed.user.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);

    User deleteUser(String userId);

    User updateUser(User user);
}
