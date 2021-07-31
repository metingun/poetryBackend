package com.backend.poem.controller;

import com.backend.poem.iface.IUserService;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.model.User;
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
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseModel add(@RequestBody User user) {
        try {
            return ResponseModel.createSuccessResponseWithData(userService.add(user), false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

}
