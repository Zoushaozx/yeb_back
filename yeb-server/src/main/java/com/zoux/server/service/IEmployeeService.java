package com.zoux.server.service;

import com.zoux.server.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zoux.server.pojo.RespBean;
import com.zoux.server.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
public interface IEmployeeService extends IService<Employee> {
    /**
     * 获取所有员工(分页)
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取工号
     * @return
     */
    RespBean maxWorkId();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmp(Employee employee);

    /**
     * 导出员工数据
     * @param id
     */
    List<Employee> getEmployee(Integer id);

    /**
     * 获取所有员工套账
     * @param currentPage
     * @param size
     * @return
     */
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}

