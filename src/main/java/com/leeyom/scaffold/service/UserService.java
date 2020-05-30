package com.leeyom.scaffold.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leeyom.scaffold.common.dto.ResultDTO;
import com.leeyom.scaffold.domain.entity.User;

/**
 * (User)表服务接口
 *
 * @author Leeyom Wang
 * @since 2020-05-30 16:17:36
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    ResultDTO<IPage<User>> selectAll(Page<User> page, User user);
}