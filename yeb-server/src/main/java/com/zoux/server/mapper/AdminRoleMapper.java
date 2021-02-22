package com.zoux.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zoux.server.pojo.AdminRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zoux
 * @since 2021-02-13
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     */
    Integer addAdminOfRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
