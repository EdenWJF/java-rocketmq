package com.jinfour.rocketmq.service.impl;

import com.jinfour.rocketmq.mapper.VvSignUserMapper;
import com.jinfour.rocketmq.model.VvUser;
import com.jinfour.rocketmq.service.UserServcie;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserServcie {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Resource
    VvSignUserMapper vvSignUserMapper;

    @Value("${server.port}")
    String port;

    @Override
    public VvUser updateUser(Long id) {
        VvUser user = vvSignUserMapper.getUser(id);
        user.setName("wangjianfa" + "from-" + port);
        vvSignUserMapper.updateUser(user);
        RLock wangjianfa = null;
        try {
            wangjianfa = redissonClient.getLock("wangjianfa");
            wangjianfa.lock(30, TimeUnit.SECONDS);
            System.out.println("--------------start---------------");
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (wangjianfa != null) {
                wangjianfa.unlock();
            }
        }
        System.out.println("--------------over---------------");
        return user;
    }
}
