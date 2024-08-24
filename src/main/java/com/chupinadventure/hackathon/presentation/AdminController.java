package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.service.CollectionProperties;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdminController {

    private final CollectionProperties collectionProperties;

    @PutMapping("/api/v1/admin/radius-meter")
    public void updateCollectionRadius(@RequestParam final double radiusMeter) {
        collectionProperties.setRadiusMeter(radiusMeter);
    }
}
