package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.service.TrashCoordinateQueryCommand;
import com.chupinadventure.hackathon.service.TrashCreateCommand;
import com.chupinadventure.hackathon.service.TrashService;
import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@AllArgsConstructor
@RestController
public class TrashController {

    private final TrashService trashService;

    @PostMapping("/api/v1/trashes")
    public void registerTrash(@RequestParam final String userId,
                              @RequestBody final TrashCreateCommand command) {
        trashService.create(userId, command);
    }

    @GetMapping("/api/v1/trashes")
    public Set<TrashResponse> trashes(@RequestParam final double north,
                                      @RequestParam final double south,
                                      @RequestParam final double east,
                                      @RequestParam final double west) {

        final TrashCoordinateQueryCommand command = TrashCoordinateQueryCommand.builder()
                .north(north)
                .south(south)
                .west(west)
                .east(east)
                .build();

        return trashService.findTrashes(command)
                .stream()
                .map(TrashResponse::of)
                .collect(ImmutableSet.toImmutableSet());
    }
}
