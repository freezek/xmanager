package com.ikm.xmanager.cms.service;

import com.baomidou.mybatisplus.service.IService;
import com.ikm.xmanager.cms.model.Role;
import com.ikm.xmanager.commons.result.PageInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * Role 表数据服务层接口
 *
 */
public interface IRoleService extends IService<Role> {

    void selectDataGrid(PageInfo pageInfo);

    Object selectTree();

    List<Long> selectResourceIdListByRoleId(Long id);

    void updateRoleResource(Long id, String resourceIds);

    Map<String, Set<String>> selectResourceMapByUserId(Long userId);

}