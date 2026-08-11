package com.example.aicoding.infra.mapper;

import com.example.aicoding.infra.po.UserInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    UserInfoPO findById(Long id);

    List<UserInfoPO> findAll();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserInfoPO po);

    int update(UserInfoPO po);

    int deleteById(Long id);
}
