package com.example.javatalks;

import java.util.List;

public interface UserManager {

    List<User> getAllUsers();

    User getUser(Long userId);

    User saveUser(User user);

    void deleteUser(Long userId);
}
