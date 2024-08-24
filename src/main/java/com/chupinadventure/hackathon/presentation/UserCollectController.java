package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.service.UserCollectingService;
import com.chupinadventure.hackathon.service.UserLocationCollectCommand;
import com.chupinadventure.hackathon.service.UserLocationEndCommand;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
public class UserCollectController {

    private final UserCollectingService userLocationService;

    @PostMapping("/api/v1/user-collect-start")
    public CollectStartResponse start(@RequestParam final String userId) {
        return new CollectStartResponse(userLocationService.start(userId));
    }

    @PostMapping("/api/v1/user-collecting")
    public void collect(@RequestBody final UserLocationCollectCommand command) {
        userLocationService.collect(command);
    }

    @PostMapping("/api/v1/user-collect-end")
    public void end(@RequestBody final UserLocationEndCommand command) {
        userLocationService.end(command);
    }
}
