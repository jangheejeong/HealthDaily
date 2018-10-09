package com.jang.healthdaily.payload.User;


import lombok.Data;

import java.time.Instant;

@Data
public class UserProfile {
    private Long id;
    private Instant joinedAt;
    private Long pollCount;
    private Long voteCount;

    public UserProfile(Long id, Instant joinedAt, Long pollCount, Long voteCount) {
        this.id = id;
        this.joinedAt = joinedAt;
        this.pollCount = pollCount;
        this.voteCount = voteCount;
    }
}