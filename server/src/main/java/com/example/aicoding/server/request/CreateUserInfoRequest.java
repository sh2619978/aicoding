package com.example.aicoding.server.request;

public class CreateUserInfoRequest {

    private String name;
    private Integer age;

    public CreateUserInfoRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
