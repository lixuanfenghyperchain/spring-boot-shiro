package com.neo.sevice;

import com.neo.model.UserInfo;

import java.util.List;

public interface UserInfoService {
    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);


    public List<UserInfo> findAllUser();


    public void deleteUserById(String id);


    public void addUser(UserInfo userInfo);
}