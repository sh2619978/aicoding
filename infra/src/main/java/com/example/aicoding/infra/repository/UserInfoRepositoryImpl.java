package com.example.aicoding.infra.repository;

import com.example.aicoding.domain.model.UserInfo;
import com.example.aicoding.domain.repository.UserInfoRepository;
import com.example.aicoding.infra.mapper.UserInfoMapper;
import com.example.aicoding.infra.po.UserInfoPO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoRepositoryImpl implements UserInfoRepository {

    private final UserInfoMapper userInfoMapper;

    public UserInfoRepositoryImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfo findById(Long id) {
        UserInfoPO po = userInfoMapper.findById(id);
        if (po == null) {
            return null;
        }
        return new UserInfo(po.getId(), po.getName(), po.getAge());
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfoPO> poList = userInfoMapper.findAll();
        List<UserInfo> result = new ArrayList<>(poList.size());
        for (UserInfoPO po : poList) {
            result.add(new UserInfo(po.getId(), po.getName(), po.getAge()));
        }
        return result;
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        UserInfoPO po = new UserInfoPO();
        po.setName(userInfo.getName());
        po.setAge(userInfo.getAge());
        userInfoMapper.insert(po);
        userInfo.setId(po.getId());
        return userInfo;
    }

    @Override
    public void update(UserInfo userInfo) {
        UserInfoPO po = new UserInfoPO();
        po.setId(userInfo.getId());
        po.setName(userInfo.getName());
        po.setAge(userInfo.getAge());
        userInfoMapper.update(po);
    }

    @Override
    public void delete(Long id) {
        userInfoMapper.deleteById(id);
    }
}
