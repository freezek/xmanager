package com.ikm.xmanager.cms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ikm.xmanager.cms.model.Resource;
import com.ikm.xmanager.cms.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * Role 表数据库控制层接口
 *
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Long> selectResourceIdListByRoleId(@Param("id") Long id);

    List<Resource> selectResourceListByRoleIdList(@Param("list") List<Long> list);

    List<Map<Long, String>> selectResourceListByRoleId(@Param("id") Long id);

}