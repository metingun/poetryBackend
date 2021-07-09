/*
package com.backend.poem.controller;

import com.backend.poem.model.ChangePasswordModel;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.model.UserInfoModel;
import com.backend.poem.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restful/user", produces = "application/json")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseModel createUser(@RequestBody UserInfoModel userInfoModel) {
        try {
            return ResponseModel
                .createSuccessResponseWithData(userService.createUser(userInfoModel, userService.getUsers()), false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public ResponseModel getUsers() {
        try {
            return ResponseModel.createSuccessResponseWithData(userService.getUsers(), false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ResponseModel changePassword(@RequestBody ChangePasswordModel changePasswordModel) {
        try {
            return ResponseModel.createSuccessResponseWithData(userService.changePassword(changePasswordModel,
                userService.getUsers()),
                false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
*/
