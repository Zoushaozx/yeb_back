package com.zoux.server.service.impl;

import com.zoux.server.pojo.Oplog;
import com.zoux.server.mapper.OplogMapper;
import com.zoux.server.service.IOplogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
@Service
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
