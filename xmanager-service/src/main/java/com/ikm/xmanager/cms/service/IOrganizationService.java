package com.ikm.xmanager.cms.service;

import com.baomidou.mybatisplus.service.IService;
import com.ikm.xmanager.cms.model.Organization;
import com.ikm.xmanager.commons.result.Tree;

import java.util.List;

/**
 *
 * Organization 表数据服务层接口
 *
 */
public interface IOrganizationService extends IService<Organization> {

    List<Tree> selectTree();

    List<Organization> selectTreeGrid();

}