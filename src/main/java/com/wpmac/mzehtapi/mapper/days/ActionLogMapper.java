package com.wpmac.mzehtapi.mapper.days;

import com.wpmac.mzehtapi.po.UserActionLog;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangpeng on 2017/1/9.
 */
public interface ActionLogMapper {

    int add(UserActionLog userActionLog);

    UserActionLog findOneById(Serializable Id);

    /**
     * 分页查询
     * @param offset    起始位置
     * @param limit     每页数量
     * @return
     */
    List<UserActionLog> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int getAllCount();
}
