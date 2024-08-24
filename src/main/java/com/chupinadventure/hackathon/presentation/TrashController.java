package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.domain.TrashType;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrashController {

    @GetMapping("/api/v1/trashes")
    public Set<Trash> trashes() {

        final Trash trash1 = new Trash(TrashType.BOTTLE, 37.5157657, 127.0990839);
        final Trash trash2 = new Trash(TrashType.ETC, 37.6157657, 127.1990839);

        return Set.of(trash1, trash2);
    }
}
