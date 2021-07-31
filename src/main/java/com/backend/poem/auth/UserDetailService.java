package com.backend.poem.auth;

import com.backend.poem.iface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserDetailService implements UserDetailsService {

    private final IUserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailService(IUserService userService,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.backend.poem.model.User user=userService.getUserByUsername(username);
        if (Objects.nonNull(user)){
            if (Objects.nonNull(user.getUsername())&&Objects.nonNull(user.getPassword())){
                return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
            }
            else {
                throw new UsernameNotFoundException(username);
            }
        }
        throw new UsernameNotFoundException(username);

    }
}
