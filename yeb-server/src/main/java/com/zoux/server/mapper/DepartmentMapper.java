package com.zoux.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zoux.server.pojo.Department;
import com.zoux.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    /**
     * 获取所有部门
     *
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     *
     * @return
     */
    void addDep(Department department);

    /**
     * 删除部门
     *
     * @param department
     */
    void deleteDep(Department department);
}
