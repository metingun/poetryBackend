/*
package com.backend.poem.controller;

import com.backend.poem.model.ResponseModel;
import com.backend.poem.model.LoginModel;
import com.backend.poem.service.LoginService;
import com.backend.poem.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restful/login", produces = "application/json")
public class LoginController {

    private final UserService userService;
    private final LoginService loginService;

    public LoginController(LoginService loginService, UserService userService) {
        this.loginService = loginService;
        this.userService = userService;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseModel loginCheck(@RequestBody LoginModel loginModel) {
        try {
            return ResponseModel.createSuccessResponseWithData(loginService.loginCheck(loginModel,
                userService.getUsers()), false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
*/
