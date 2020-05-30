package com.leeyom.scaffold.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeyom.scaffold.domain.entity.User;

/**
 * 用户仓储层
 *
 * @author leeyom
 */
public interface UserRepository {

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    IPage<User> selectAll(Page<User> page, User user);
}
