package com.zoux.server.service.impl;

import com.zoux.server.pojo.Role;
import com.zoux.server.mapper.RoleMapper;
import com.zoux.server.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
