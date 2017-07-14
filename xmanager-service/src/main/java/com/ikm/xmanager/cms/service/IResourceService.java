package com.ikm.xmanager.cms.service;

import com.baomidou.mybatisplus.service.IService;
import com.ikm.xmanager.cms.model.Resource;
import com.ikm.xmanager.commons.result.Tree;
import com.ikm.xmanager.commons.shiro.ShiroUser;

import java.util.List;

/**
 *
 * Resource 表数据服务层接口
 *
 */
public interface IResourceService extends IService<Resource> {

    List<Resource> selectAll();

    List<Tree> selectAllMenu();

    List<Tree> selectAllTree();

    List<Tree> selectTree(ShiroUser shiroUser);

}