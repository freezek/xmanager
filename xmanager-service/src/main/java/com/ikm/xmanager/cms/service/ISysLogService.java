package com.ikm.xmanager.cms.service;

import com.baomidou.mybatisplus.service.IService;
import com.ikm.xmanager.cms.model.SysLog;
import com.ikm.xmanager.commons.result.PageInfo;

/**
 *
 * SysLog 表数据服务层接口
 *
 */
public interface ISysLogService extends IService<SysLog> {

    void selectDataGrid(PageInfo pageInfo);

}