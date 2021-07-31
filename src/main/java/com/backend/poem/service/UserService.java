package com.backend.poem.service;

import com.backend.poem.iface.IUserService;
import com.backend.poem.model.Login;
import com.backend.poem.model.User;

import com.backend.poem.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService implements IUserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo=userRepo;
    }

    @Override
    public Integer add(User user) {
        List<User> users= userRepo.findAllByUsername(user.getUsername());
        if (users.size()==0){
            userRepo.save(user);
            return 200;
        }else{
            return 400;
        }
    }

    @Override
    public Integer login(Login login) {
        User user=userRepo.findAllByUsernameAndPassword(login.getUsername(),login.getPassword());
        if (Objects.nonNull(user)){
            return 200;
        }
        return 400;
    }

    @Override
    public User getUserByUsername(String username) {
        User user=userRepo.findByUsername(username);
        if (Objects.nonNull(user)){
            return user;
        }
        return null;
    }
}
