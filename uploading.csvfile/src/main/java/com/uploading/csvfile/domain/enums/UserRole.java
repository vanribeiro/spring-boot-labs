package com.uploading.csvfile.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enum para definir os papeis/niveis/roles do usuario", allowableValues = { "ADMIN", "USER" })
public enum UserRole {
    @Schema(description = "Administrator")
    ADMIN("admin"),
    @Schema(description = "Usuário comum")
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    @JsonValue
    @Schema(description = "Obter o valor textual da role para serialização")
    public String getRole() {
        return role;
    }

    @JsonCreator
    public static UserRole fromRole(String userRole) {
        for (UserRole uRole : values()) {
            if (uRole.role.equalsIgnoreCase(userRole)) {
                return uRole;
            }
        }
        throw new IllegalArgumentException("Role inválida:" + userRole);
    }
}
