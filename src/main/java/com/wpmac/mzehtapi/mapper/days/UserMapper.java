package com.wpmac.mzehtapi.mapper.days;

import com.wpmac.mzehtapi.po.User;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangpeng on 2017/1/9.
 */
public interface UserMapper {

    int add(User user);

    int del(User user);

    int update(User user);

    User findOneById(Serializable Id);

    List<User> findAll();

    void updateLoginSession(@Param("sessionId") String sessionId, @Param("loginId") String loginId);

    void addSessionId(String id);
}
