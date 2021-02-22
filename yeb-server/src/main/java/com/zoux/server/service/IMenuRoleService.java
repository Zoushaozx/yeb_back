package com.zoux.server.service;

import com.zoux.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zoux.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
public interface IMenuRoleService extends IService<MenuRole> {
    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuOfRole(Integer rid, Integer[] mids);
}
