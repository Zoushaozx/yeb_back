package com.zoux.server.controller;


import com.zoux.server.pojo.Position;
import com.zoux.server.pojo.RespBean;
import com.zoux.server.service.IPositionService;
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
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        //当前时间
        position.setCreateDate(LocalDateTime.now());
        //保存position
        if (positionService.save(position)) {
            return RespBean.success("添加成功");
        }
        return RespBean.success("添加失败");
    }

    @ApiOperation(value = "更新职位信息")
    //REST风格
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        //更新position
        if (positionService.updateById(position)) {
            return RespBean.success("更新成功");
        }
        return RespBean.success("更新失败");
    }

    @ApiOperation(value = "删除职位信息")
    //REST风格
    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        //删除position
        if (positionService.removeById(id)) {
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }

    @ApiOperation(value = "批量删除职位信息")
    //REST风格
    @DeleteMapping("/")
    public RespBean deletePositions(Integer[] ids) {
        //删除position
        if (positionService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }
}
