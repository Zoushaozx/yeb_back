package com.zoux.server.service.impl;

import com.zoux.server.mapper.AdminMapper;
import com.zoux.server.mapper.MenuMapper;
import com.zoux.server.pojo.Admin;
import com.zoux.server.pojo.Menu;
import com.zoux.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 通过用户id查询菜单列表
     *
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = ((Admin) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        //先去redis获取
        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
        //判断menus是否为空,就通过数据库进行查询
        if (CollectionUtils.isEmpty(menus)) {
            menus = menuMapper.getMenusAdminId(adminId);
            //将数据设置到redis中
            valueOperations.set("menu_" + adminId, menus);
        }
        return menus;
    }

    /***
     * 根据角色获取菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

    /**
     * 查询所有菜单
     *
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
