/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: RoleService
 * Author:   lixuanfeng
 * Date:     2019/6/21 下午2:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.neo.sevice;

import com.neo.model.SysRole;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/21
 * @since 1.0.0
 */
public interface RoleService {

    List<SysRole> getAllRoles();

    void addRole(SysRole role);


    SysRole getRoleById(String id);


    void save(SysRole role);
}