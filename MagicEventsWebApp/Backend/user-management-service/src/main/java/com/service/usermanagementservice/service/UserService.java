package com.service.usermanagementservice.service;

import com.service.usermanagementservice.dto.UserDTO;
import com.service.usermanagementservice.model.OauthToken;
import com.service.usermanagementservice.model.User;
import com.service.usermanagementservice.repository.OauthTokenRepository;
import com.service.usermanagementservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OauthTokenRepository tokenRepository;

    public HashMap<Long, String> getUserEmail(List<String> email) throws Exception {
        HashMap<Long, String> usersValues = new HashMap<>();
        for (String s : email) {
            User user = userRepository.findByEmail(s);
            if (user != null) {
                usersValues.put(user.getMagicEventTag(), user.getEmail());
            }else{
                throw new Exception("User not exist");
            }
        }
        return usersValues;
    }

    public Boolean isAuthenticated(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            OauthToken oauthToken = tokenRepository.findByUser(user);
            return oauthToken != null && !oauthToken.getExpirationTime().isBefore(LocalDateTime.now());
        }else{
            throw new Exception("User not exist");
        }
    }

    public UserDTO userProfile(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("User not found: " + id));
        return new UserDTO(
                user.getMagicEventTag(),
                user.getUsername(),
                user.getEmail(),
                user.getProfileImageUrl(),
                user.getName(),
                user.getSurname()
        );
    }
}