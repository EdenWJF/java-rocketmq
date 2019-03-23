package com.jinfour.rocketmq.controller;

import com.alibaba.fastjson.JSON;
import com.jinfour.rocketmq.mapper.VvSignUserMapper;
import com.jinfour.rocketmq.model.VvUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pay")
public class UserController {

    @Autowired
    VvSignUserMapper user;

    @Autowired
    RedisTemplate redisTemplate;

    @ResponseBody
    @GetMapping("/payment")
    public Object pay() {
        HashMap map = new HashMap();
        map.put("haha", "fsfdsdf");
        redisTemplate.opsForValue().set("haha", 1);
        VvUser user = this.user.getUser(1L);
        return user;
    }
}
