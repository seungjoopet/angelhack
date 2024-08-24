package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.Trash;
import com.chupinadventure.hackathon.domain.TrashRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TrashService {

    private final TrashRepository repository;

    @Transactional
    public void create(final String userId, final TrashCreateCommand command) {
        final Trash trash = Trash.of(userId, command);
        repository.save(trash);
    }
}
