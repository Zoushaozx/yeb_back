package com.zoux.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zoux.server.pojo.Admin;
import com.zoux.server.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 获取所有操作员
     *
     * @param keyword
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keyword") String keyword);

}
