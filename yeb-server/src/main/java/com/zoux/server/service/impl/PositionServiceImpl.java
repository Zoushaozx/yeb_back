package com.zoux.server.service.impl;

import com.zoux.server.pojo.Position;
import com.zoux.server.mapper.PositionMapper;
import com.zoux.server.service.IPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {
}
