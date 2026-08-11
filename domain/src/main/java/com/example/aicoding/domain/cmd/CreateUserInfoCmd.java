package com.example.aicoding.domain.cmd;

public class CreateUserInfoCmd {

    private String name;
    private Integer age;

    public CreateUserInfoCmd() {
    }

    public CreateUserInfoCmd(String name, Integer age) {
        this.name = name;
        this.age = age;
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
