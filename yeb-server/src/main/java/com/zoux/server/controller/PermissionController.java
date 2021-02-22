package com.zoux.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zoux.server.pojo.Menu;
import com.zoux.server.pojo.MenuRole;
import com.zoux.server.pojo.RespBean;
import com.zoux.server.pojo.Role;
import com.zoux.server.service.IMenuRoleService;
import com.zoux.server.service.IMenuService;
import com.zoux.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限组
 */
@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IMenuRoleService menuRoleService;

    @ApiOperation(value = "获取所有角色信息")
    @GetMapping("/")
    public List<Role> getAllRole() {
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        //更改名称
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        //保存position
        if (roleService.save(role)) {
            return RespBean.success("添加成功");
        }
        return RespBean.success("添加失败");
    }


    @ApiOperation(value = "删除角色")
    //REST风格
    @DeleteMapping("/role/{id}")
    public RespBean deleteRole(@PathVariable Integer id) {
        //删除position
        if (roleService.removeById(id)) {
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid) {
        return menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid", rid)).stream().map(MenuRole::getMid).collect(Collectors.toList());
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuOfRole(Integer rid, Integer[] mids) {
        return menuRoleService.updateMenuOfRole(rid, mids);
    }
}
