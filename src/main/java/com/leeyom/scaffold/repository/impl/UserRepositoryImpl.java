package com.leeyom.scaffold.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeyom.scaffold.domain.entity.User;
import com.leeyom.scaffold.mapper.UserMapper;
import com.leeyom.scaffold.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * user 仓储层实现类
 *
 * @author leeyom
 */
@Repository(value = "userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> selectAll(Page<User> page, User user) {
        return userMapper.selectPage(page, new QueryWrapper<>(user));
    }
}
