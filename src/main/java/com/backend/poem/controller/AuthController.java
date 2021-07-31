package com.backend.poem.controller;

import com.backend.poem.auth.TokenManager;
import com.backend.poem.iface.IUserService;
import com.backend.poem.model.Login;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login", produces = "application/json")
public class AuthController {


    public AuthController() {

    }
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private AuthenticationManager authenticationManager;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseModel login(@RequestBody Login login) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            login.getUsername(),login.getPassword()));
            return ResponseModel.createSuccessResponseWithData(tokenManager.generateToken(login), false);
            /*return ResponseModel.createSuccessResponseWithData(userService.login(login), false);*/
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
