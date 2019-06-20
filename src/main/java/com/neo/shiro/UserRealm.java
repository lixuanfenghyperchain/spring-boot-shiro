/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: UserRealm
 * Author:   lixuanfeng
 * Date:     2019/6/20 上午10:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.neo.shiro;

import com.neo.model.SysPermission;
import com.neo.model.SysRole;
import com.neo.model.UserInfo;
import com.neo.sevice.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/20
 * @since 1.0.0
 */
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private UserInfoService userInfoService;

    /**
     * 授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
//        给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        //获取用户的所有角色
        for (SysRole r : userInfo.getRoleList()) {
            //对角色的资源进行遍历
            for (SysPermission p : r.getPermissions()) {
                info.addStringPermission(p.getPermission());
            }
        }
        return info;
    }


    /**
     * 认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取用户名
        String username = token.getUsername();
        UserInfo userInfo = userInfoService.findByUsername(username);
        // 1判断用户名
        if (null == userInfo || "".equals(userInfo)) {
            return null;
        }
        return new SimpleAuthenticationInfo("", userInfo.getPassword(), "");
    }
}