package com.backend.poem.controller;

import com.backend.poem.auth.TokenManager;
import com.backend.poem.iface.IUserService;
import com.backend.poem.model.Login;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restful/user", produces = "application/json")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseModel add(@RequestBody User user) {
        try {
            return ResponseModel.createSuccessResponseWithData(userService.add(user), false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseModel login(@RequestBody Login login) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            login.getUsername(),login.getPassword()));
            return ResponseModel.createSuccessResponseWithData(tokenManager.generateToken(login.getUsername()), false);
            /*return ResponseModel.createSuccessResponseWithData(userService.login(login), false);*/
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
