package com.backend.poem.iface;

import com.backend.poem.model.Login;
import com.backend.poem.model.User;

public interface IUserService {

    Integer add(User user);

    Integer login(Login login);

    User getUserByUsername(String username);

}
