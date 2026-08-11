package com.example.aicoding.domain.repository;

import com.example.aicoding.domain.model.UserInfo;

import java.util.List;

public interface UserInfoRepository {

    UserInfo findById(Long id);

    List<UserInfo> findAll();

    UserInfo save(UserInfo userInfo);

    void update(UserInfo userInfo);

    void delete(Long id);
}
