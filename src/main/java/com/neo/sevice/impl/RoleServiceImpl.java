/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: RoleServiceImpl
 * Author:   lixuanfeng
 * Date:     2019/6/21 下午2:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.neo.sevice.impl;

import com.neo.dao.RoleDao;
import com.neo.model.SysRole;
import com.neo.sevice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/21
 * @since 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<SysRole> getAllRoles() {
        return (List<SysRole>) roleDao.findAll();
    }

    @Override
    public void addRole(SysRole role) {
        roleDao.save(role);
    }

    @Override
    public SysRole getRoleById(String id) {
        return roleDao.findById(Integer.valueOf(id)).get();
    }

    @Override
    public void save(SysRole role) {
        roleDao.save(role);
    }
}