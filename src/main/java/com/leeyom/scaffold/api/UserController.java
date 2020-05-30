package com.leeyom.scaffold.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeyom.scaffold.common.dto.ResultDTO;
import com.leeyom.scaffold.domain.entity.User;
import com.leeyom.scaffold.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (User)表控制层
 *
 * @author Leeyom Wang
 * @since 2020-05-30 16:17:37
 */
@RestController
@RequestMapping("user")
public class UserController extends ApiController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping("selectAll")
    public ResultDTO<IPage<User>> selectAll(Page<User> page, User user) {
        return userService.selectAll(page, user);
    }
}