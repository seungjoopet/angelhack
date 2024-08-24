package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.domain.TrashType;
import java.util.Set;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrashController {

    @CrossOrigin
    @GetMapping("/api/v1/trashes")
    public Set<Trash> trashes() {

        final Trash trash1 = new Trash(TrashType.BOTTLE, new Location(37.5157657, 127.0990839));
        final Trash trash2 = new Trash(TrashType.ETC, new Location(37.6157657, 127.1990839));

        return Set.of(trash1, trash2);
    }
}
