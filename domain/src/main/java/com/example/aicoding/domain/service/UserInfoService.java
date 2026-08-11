package com.example.aicoding.domain.service;

import com.example.aicoding.domain.cmd.CreateUserInfoCmd;
import com.example.aicoding.domain.cmd.DeleteUserInfoCmd;
import com.example.aicoding.domain.cmd.UpdateUserInfoCmd;
import com.example.aicoding.domain.model.UserInfo;
import com.example.aicoding.domain.repository.UserInfoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo getUserInfo(Long id) {
        return userInfoRepository.findById(id);
    }

    public List<UserInfo> listUserInfos() {
        return userInfoRepository.findAll();
    }

    public UserInfo createUserInfo(CreateUserInfoCmd cmd) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(cmd.getName());
        userInfo.setAge(cmd.getAge());
        return userInfoRepository.save(userInfo);
    }

    public void updateUserInfo(UpdateUserInfoCmd cmd) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(cmd.getId());
        userInfo.setName(cmd.getName());
        userInfo.setAge(cmd.getAge());
        userInfoRepository.update(userInfo);
    }

    public void deleteUserInfo(DeleteUserInfoCmd cmd) {
        userInfoRepository.delete(cmd.getId());
    }
}
