/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: PermissionController
 * Author:   lixuanfeng
 * Date:     2019/6/21 下午2:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.neo.web;

import com.neo.model.SysPermission;
import com.neo.model.SysRole;
import com.neo.sevice.PermService;
import com.neo.sevice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/21
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/perm")
public class PermissionController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermService permService;

    /**
     * 做跳转到角色添加页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "perm/permAdd";
    }


    /**
     * 权限列表.
     *
     * @return
     */
    @RequestMapping("/permList")
    public String permList(Model model, String id) {
        SysRole role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "perm/list";
    }


    /**
     * 做跳转到给角色授权页面
     *
     * @return
     */
    @RequestMapping("/rolePermAdd")
    public String rolePermAdd(Model model, String rid) {
        model.addAttribute("rid", rid);
        return "perm/rolePermAdd";
    }


    /**
     * 给某个角色赋予某个资源权限
     *
     * @return
     */
    @RequestMapping("/add")
    public String addPerm(Model model, SysPermission per, String rid) {
        SysRole role = roleService.getRoleById(rid);
        role.getPermissions().add(per);
        roleService.save(role);
        model.addAttribute("role", role);
        return "redirect:/perm/permList?id=" + role.getId();
    }


    /**
     * 添加资源
     *
     * @return
     */
    @RequestMapping("/save")
    public String save(SysPermission per) {
        permService.save(per);
        return "redirect:/permList";
    }
}