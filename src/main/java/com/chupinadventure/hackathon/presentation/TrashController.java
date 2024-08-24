package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.domain.TrashType;
import com.chupinadventure.hackathon.service.TrashCreateCommand;
import com.chupinadventure.hackathon.service.TrashService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static com.chupinadventure.hackathon.constant.CookieName.USER_ID;

@CrossOrigin
@AllArgsConstructor
@RestController
public class TrashController {

    private final TrashService trashService;

    @PostMapping("/api/v1/trashes")
    public void registerTrash(@CookieValue(USER_ID) final String userId,
                              @RequestBody final TrashCreateCommand command) {
        trashService.create(userId, command);
    }

    @GetMapping("/api/v1/trashes")
    public Set<Trash> trashes() {

        final Trash trash1 = new Trash(TrashType.BOTTLE, new Location(37.5157657, 127.0990839));
        final Trash trash2 = new Trash(TrashType.ETC, new Location(37.6157657, 127.1990839));

        return Set.of(trash1, trash2);
    }
}
