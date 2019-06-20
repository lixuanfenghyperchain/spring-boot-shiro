package com.neo.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping({"/index"})
    public String index(Model model) {
        model.addAttribute("name", "lxf");
        return "index";
    }


    /**
     * 暂无权限页面
     *
     * @param model
     * @return
     */
    @RequestMapping({"/noAuth"})
    public String noAuth(Model model) {
        return "403";
    }


    @RequestMapping({"/toLogin"})
    public String toLogin() {
        return "login";
    }


    @RequestMapping("/login")
    public String login(String name, String password, Model model) {
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //3.执行登录方法
        try {
            subject.login(token);
            //登录成功
            //跳转到test.html
            return "index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            //登录失败:密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("位置异常");
            return "login";
        }
    }

}