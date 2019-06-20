package com.neo.sevice.impl;

import com.neo.dao.UserInfoDao;
import com.neo.model.UserInfo;
import com.neo.sevice.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }


    @Override
    public List<UserInfo> findAllUser() {
        Iterable<UserInfo> users = userInfoDao.findAll();
        return (List<UserInfo>) users;
    }

    @Override
    public void deleteUserById(String id) {
        userInfoDao.deleteById((Integer.valueOf(id)));
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoDao.save(userInfo);
    }


}