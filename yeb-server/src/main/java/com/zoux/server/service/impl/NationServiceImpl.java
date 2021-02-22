package com.zoux.server.service.impl;

import com.zoux.server.pojo.Nation;
import com.zoux.server.mapper.NationMapper;
import com.zoux.server.service.INationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
