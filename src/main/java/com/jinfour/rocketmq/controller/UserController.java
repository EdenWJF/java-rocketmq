package com.jinfour.rocketmq.controller;

import com.jinfour.rocketmq.service.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pay")
public class UserController {

    @Autowired
    private UserServcie userServcie;

    @ResponseBody
    @GetMapping("/payment")
    public Object pay() {

        return userServcie.updateUser(1L);
    }
}
