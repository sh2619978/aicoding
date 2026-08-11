package com.example.aicoding.domain.cmd;

public class DeleteUserInfoCmd {

    private Long id;

    public DeleteUserInfoCmd() {
    }

    public DeleteUserInfoCmd(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
