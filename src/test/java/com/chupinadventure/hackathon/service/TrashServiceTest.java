package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.TrashRepository;
import com.chupinadventure.hackathon.domain.TrashType;
import com.chupinadventure.hackathon.presentation.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrashServiceTest {

    @Autowired
    private TrashService service;

    @Autowired
    private TrashRepository repository;

    @Test
    void createTrash() {
        // given
        final Location location = new Location(10.01, 20.33);
        final TrashCreateCommand command = new TrashCreateCommand(location, TrashType.CAN);

        // when
        service.create("userId1", command);

        // then
        repository.findAll()
                .forEach(System.out::println);

        repository.findAll();
    }
}