package com.example.backend.db;

import com.example.backend.models.User;

public interface UserRepoInterface {
    public User login(User user);
    public User register(User user);
    public int changePassword(User user);
}
