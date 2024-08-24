package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.User;
import com.chupinadventure.hackathon.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void create(final String userId) {
        final User user = User.of(userId);
        userRepository.save(user);
    }
}
