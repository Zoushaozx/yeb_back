package com.zoux.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zoux.server.mapper.EmployeeMapper;
import com.zoux.server.pojo.Employee;
import com.zoux.server.pojo.EmployeeEc;
import com.zoux.server.mapper.EmployeeEcMapper;
import com.zoux.server.pojo.RespBean;
import com.zoux.server.pojo.RespPageBean;
import com.zoux.server.service.IEmployeeEcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
@Service
public class EmployeeEcServiceImpl extends ServiceImpl<EmployeeEcMapper, EmployeeEc> implements IEmployeeEcService {

}
