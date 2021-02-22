package com.zoux.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zoux.server.pojo.Employee;
import com.zoux.server.pojo.EmployeeEc;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * 获取所有员工(分页)
     * @param page
     * @param employee
     * @param beginDateScope
     */
    IPage<Employee> getEmployeeByPage( Page<EmployeeEc> page, @Param("employee") Employee employee, @Param("beginDateScope") LocalDate[] beginDateScope);

    /**
     * 导出员工数据
     * @param id
     * @return
     */
    List<Employee> getEmployee(Integer id);

    /**
     * 获取所有员工套账
     */
    IPage<Employee> getEmployeeWithSalary(Page<Employee> page);
}
