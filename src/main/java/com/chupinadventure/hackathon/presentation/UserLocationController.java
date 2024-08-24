package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.service.UserLocationCreateCommand;
import com.chupinadventure.hackathon.service.UserLocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@AllArgsConstructor
@RestController
public class UserLocationController {

    private final UserLocationService userLocationService;

    @PostMapping("/api/v1/user-locations")
    public void registerLocation(@RequestBody final UserLocationCreateCommand command) {
        userLocationService.create(command);
    }
}
