package com.jinfour.rocketmq.mapper;

import com.jinfour.rocketmq.model.VvUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VvSignUserMapper{
    VvUser getUser(@Param("id") Long id);

    void updateUser(VvUser user);
}