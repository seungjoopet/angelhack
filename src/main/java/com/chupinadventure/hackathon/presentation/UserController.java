package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/api/test/user")
    public void registerUser(@RequestParam final String userId) {
        userService.create(userId);
    }
}
