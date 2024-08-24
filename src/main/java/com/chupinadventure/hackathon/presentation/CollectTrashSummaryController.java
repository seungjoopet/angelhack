package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.service.CollectedTrashSummaryService;
import com.chupinadventure.hackathon.service.UserCollectSummary;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CollectTrashSummaryController {

    private final CollectedTrashSummaryService collectedTrashSummaryService;

    @GetMapping("/api/v1/trash-summary")
    public UserCollectSummary trashSummary(@RequestParam final long collectId) {
        return collectedTrashSummaryService.summary(collectId);
    }
}
