package com.example.aicoding.server.controller;

import com.example.aicoding.domain.cmd.CreateUserInfoCmd;
import com.example.aicoding.domain.cmd.DeleteUserInfoCmd;
import com.example.aicoding.domain.cmd.UpdateUserInfoCmd;
import com.example.aicoding.domain.model.UserInfo;
import com.example.aicoding.domain.service.UserInfoService;
import com.example.aicoding.server.request.CreateUserInfoRequest;
import com.example.aicoding.server.request.UpdateUserInfoRequest;
import com.example.aicoding.server.response.ApiResponse;
import com.example.aicoding.server.response.UserInfoResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping
    public ApiResponse<UserInfoResponse> createUserInfo(@RequestBody CreateUserInfoRequest req) {
        CreateUserInfoCmd cmd = new CreateUserInfoCmd();
        cmd.setName(req.getName());
        cmd.setAge(req.getAge());
        UserInfo userInfo = userInfoService.createUserInfo(cmd);
        UserInfoResponse resp = new UserInfoResponse();
        resp.setId(userInfo.getId());
        resp.setName(userInfo.getName());
        resp.setAge(userInfo.getAge());
        return ApiResponse.success(resp);
    }

    @PutMapping
    public ApiResponse<UserInfoResponse> updateUserInfo(@RequestBody UpdateUserInfoRequest req) {
        UpdateUserInfoCmd cmd = new UpdateUserInfoCmd();
        cmd.setId(req.getId());
        cmd.setName(req.getName());
        cmd.setAge(req.getAge());
        userInfoService.updateUserInfo(cmd);
        UserInfoResponse resp = new UserInfoResponse();
        resp.setId(req.getId());
        resp.setName(req.getName());
        resp.setAge(req.getAge());
        return ApiResponse.success(resp);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUserInfo(@PathVariable Long id) {
        DeleteUserInfoCmd cmd = new DeleteUserInfoCmd();
        cmd.setId(id);
        userInfoService.deleteUserInfo(cmd);
        return ApiResponse.success(null);
    }

    @GetMapping("/{id}")
    public ApiResponse<UserInfoResponse> getUserInfo(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.getUserInfo(id);
        UserInfoResponse resp = new UserInfoResponse();
        resp.setId(userInfo.getId());
        resp.setName(userInfo.getName());
        resp.setAge(userInfo.getAge());
        return ApiResponse.success(resp);
    }

    @GetMapping("/list")
    public ApiResponse<List<UserInfoResponse>> listUserInfos() {
        List<UserInfo> userInfos = userInfoService.listUserInfos();
        List<UserInfoResponse> respList = userInfos.stream().map(userInfo -> {
            UserInfoResponse resp = new UserInfoResponse();
            resp.setId(userInfo.getId());
            resp.setName(userInfo.getName());
            resp.setAge(userInfo.getAge());
            return resp;
        }).collect(Collectors.toList());
        return ApiResponse.success(respList);
    }
}
