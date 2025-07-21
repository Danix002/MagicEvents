package com.service.usermanagementservice.dto;

import java.time.LocalDateTime;

public class LoginWithTokenDTO {
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expirationTime;

    public LoginWithTokenDTO(String accessToken, String refreshToken, LocalDateTime expirationTime) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expirationTime = expirationTime;
    }

    public LoginWithTokenDTO() {}

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }
}