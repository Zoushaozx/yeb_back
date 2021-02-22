package com.zoux.server.service;

import com.zoux.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 通过用户id查询菜单列表
     *
     * @return
     */
    List<Menu> getMenusByAdminId();

    /***
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<Menu> getAllMenus();
}
