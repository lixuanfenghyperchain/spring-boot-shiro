package com.neo.web;

import com.neo.model.UserInfo;
import com.neo.sevice.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户查询.
     *
     * @return
     */
    @RequestMapping("/userList")
    public String userList(Model model) {
        List<UserInfo> users = userInfoService.findAllUser();
        model.addAttribute("users", users);
        return "user/list";
    }


    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }


    /**
     * 用户添加;
     *
     * @return
     */
    @RequestMapping("/add")
    public String userInfoAdd(UserInfo user) {
        userInfoService.addUser(user);
        return "redirect:/user/userList";
    }

    /**
     * 用户删除;
     *
     * @return
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(String id) {
        userInfoService.deleteUserById(id);
        return "redirect:/user/userList";
    }
}