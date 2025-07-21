package com.service.usermanagementservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class UserDTO {
    @NotNull(message = "Magic Events Tag is required")
    @Positive(message = "Magic Events Tag must be positive")
    private Long magicEventTag;
    @NotNull(message = "Username is required")
    private String username;
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "Profile image is required")
    private String profileImageUrl;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Surname is required")
    private String surname;
    @NotNull(message = "Token is required")
    private String token;
    @NotNull(message = "Expiration time is required")
    private LocalDateTime expirationTime;
    @NotNull(message = "Refresh token is required")
    private String refreshToken;

    public UserDTO(
            Long magicEventTag,
            String username,
            String email,
            String profileImageUrl,
            String name,
            String surname,
            String token,
            LocalDateTime expirationTime,
            String refreshToken
    ) {
        this.magicEventTag = magicEventTag;
        this.username = username;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.name = name;
        this.surname = surname;
        this.token = token;
        this.expirationTime = expirationTime;
        this.refreshToken = refreshToken;
    }

    public UserDTO(
            Long magicEventTag,
            String username,
            String email,
            String profileImageUrl,
            String name,
            String surname
    ) {
        this.magicEventTag = magicEventTag;
        this.username = username;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.name = name;
        this.surname = surname;
    }

    public Long getMagicEventTag() {
        return magicEventTag;
    }

    public void setMagicEventTag(Long magicEventTag) {
        this.magicEventTag = magicEventTag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String role) {
        this.token = role;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}

