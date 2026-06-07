package com.uploading.csvfile.domain.repository;

import java.util.Optional;

import com.uploading.csvfile.domain.models.User;

public interface UserRepository {
    Optional<User> findById(String id);
    Optional<User> findByLogin(String login);
    void saveUser(User user);
    void delete(String id);
    boolean hasLogin(String login);
}
