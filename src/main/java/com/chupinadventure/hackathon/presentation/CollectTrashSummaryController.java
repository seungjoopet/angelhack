package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.domain.Trash;
import com.chupinadventure.hackathon.service.CollectedTrashSummaryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class CollectTrashSummaryController {

    private final CollectedTrashSummaryService collectedTrashSummaryService;
    
    @GetMapping("/api/v1/trash-summary")
    public Set<Trash> trashSummary(@RequestParam final long collectId) {
        return collectedTrashSummaryService.summary(collectId);
    }
}
