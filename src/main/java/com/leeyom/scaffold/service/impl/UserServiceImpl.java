package com.leeyom.scaffold.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leeyom.scaffold.common.dto.ApiResponse;
import com.leeyom.scaffold.domain.entity.User;
import com.leeyom.scaffold.mapper.UserMapper;
import com.leeyom.scaffold.repository.UserRepository;
import com.leeyom.scaffold.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author Leeyom Wang
 * @since 2020-05-30 16:17:36
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApiResponse<IPage<User>> selectAll(Page<User> page, User user) {
        return ApiResponse.ofSuccess(userRepository.selectAll(page, user));
    }
}