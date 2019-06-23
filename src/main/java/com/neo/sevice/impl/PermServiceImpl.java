/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: PermServiceImpl
 * Author:   lixuanfeng
 * Date:     2019/6/21 下午3:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.neo.sevice.impl;

import com.neo.dao.PermissionDao;
import com.neo.model.SysPermission;
import com.neo.sevice.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/21
 * @since 1.0.0
 */
@Service
public class PermServiceImpl implements PermService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void addPerm(String rId, String pId) {
    }

    @Override
    public void save(SysPermission permission) {
        permissionDao.save(permission);
    }
}