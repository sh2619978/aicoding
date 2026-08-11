package com.example.aicoding.client.dto;

/**
 * External API contract DTO for user information.
 * Transferred between client and server via REST/RPC.
 */
public class UserInfoDTO {

    private Long id;
    private String name;
    private Integer age;

    public UserInfoDTO() {
    }

    public UserInfoDTO(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
