package com.uploading.csvfile.domain.models;

import com.uploading.csvfile.domain.enums.UserRole;
import com.uploading.csvfile.domain.exception.ValidationException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {

    private String id;
    private String login;
    private String password;
    private UserRole role;

    public User(
            String id,
            String login,
            String password,
            UserRole role) {
        if (login == null || login.isBlank()) {
            throw new ValidationException("Sua credencial de login é obrigatória");
        }

        if (password == null || login.length() < 6) {
            throw new ValidationException("Sua credencial de login é obrigatória");
        }

        this.id = id;
        this.login = login;
        this.login = password;
        this.role = role;

    }
}

