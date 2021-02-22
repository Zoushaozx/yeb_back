package com.zoux.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zoux.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户id查询菜单列表
     *
     * @param id
     * @return
     */
    List<Menu> getMenusAdminId(Integer id);

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
