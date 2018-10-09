package com.jang.healthdaily.payload.User;

import lombok.Data;

@Data
public class UserSummary {
    private Long id;
    private String userName;

    public UserSummary(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}