/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: RoleController
 * Author:   lixuanfeng
 * Date:     2019/6/21 下午2:34
 * Description: 角色管理控制层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.neo.web;

import com.neo.model.SysRole;
import com.neo.model.UserInfo;
import com.neo.sevice.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈角色管理控制层〉
 *
 * @author lixuanfeng
 * @create 2019/6/21
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;


    /**
     * 角色查询.
     *
     * @return
     */
    @RequestMapping("/roleList")
    public String userList(Model model) {
        List<SysRole> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "role/list";
    }

    /**
     * 做跳转到角色添加页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "role/roleAdd";
    }


    /**
     * 用户添加;
     *
     * @return
     */
    @RequestMapping("/add")
    public String userInfoAdd(SysRole role) {
        roleService.addRole(role);
        return "redirect:/role/roleList";
    }


}