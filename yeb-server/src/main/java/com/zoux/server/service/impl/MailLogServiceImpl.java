package com.zoux.server.service.impl;

import com.zoux.server.pojo.MailLog;
import com.zoux.server.mapper.MailLogMapper;
import com.zoux.server.service.IMailLogService;
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
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
