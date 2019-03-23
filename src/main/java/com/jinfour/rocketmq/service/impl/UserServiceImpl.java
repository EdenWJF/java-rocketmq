package com.jinfour.rocketmq.service.impl;

import com.distributedlock.manager.ILockManager;
import com.distributedlock.properties.LockProperties;
import com.jinfour.rocketmq.mapper.VvSignUserMapper;
import com.jinfour.rocketmq.model.VvUser;
import com.jinfour.rocketmq.service.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserServcie {


    @Autowired
    RedisTemplate redisTemplate;

    @Resource
    VvSignUserMapper vvSignUserMapper;

    @Resource
    private ILockManager lockManager;

    @Value("${server.port}")
    String port;

    @Autowired
    private LockProperties lockProperties;

    @Override
    public VvUser updateUser(Long id) {
        VvUser user = vvSignUserMapper.getUser(id);
        user.setName("wangjianfa" + "from-" + port);
        vvSignUserMapper.updateUser(user);
        return user;
    }
}
