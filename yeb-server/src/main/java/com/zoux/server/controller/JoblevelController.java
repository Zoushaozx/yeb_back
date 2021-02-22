package com.zoux.server.controller;


import com.zoux.server.pojo.Joblevel;
import com.zoux.server.pojo.Position;
import com.zoux.server.pojo.RespBean;
import com.zoux.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称信息")
    @GetMapping("/")
    public List<Joblevel> getAllJoblevel() {
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称信息")
    @PostMapping("/")
    public RespBean addJoblevel(@RequestBody Joblevel joblevel) {
        //当前时间
        joblevel.setCreateDate(LocalDateTime.now());
        //保存position
        if (joblevelService.save(joblevel)) {
            return RespBean.success("添加成功");
        }
        return RespBean.success("添加失败");
    }

    @ApiOperation(value = "更新职称信息")
    //REST风格
    @PutMapping("/")
    public RespBean updateJoblevel(@RequestBody Joblevel joblevel) {
        //更新position
        if (joblevelService.updateById(joblevel)) {
            return RespBean.success("更新成功");
        }
        return RespBean.success("更新失败");
    }

    @ApiOperation(value = "删除职称信息")
    //REST风格
    @DeleteMapping("/{id}")
    public RespBean deleteJoblevel(@PathVariable Integer id) {
        //删除position
        if (joblevelService.removeById(id)) {
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }

    @ApiOperation(value = "批量删除职称信息")
    //REST风格
    @DeleteMapping("/")
    public RespBean deleteJoblevel(Integer[] ids) {
        //删除position
        if (joblevelService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }
}
