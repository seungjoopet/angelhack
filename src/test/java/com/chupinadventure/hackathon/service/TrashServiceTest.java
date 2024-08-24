package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.TrashRepository;
import com.chupinadventure.hackathon.domain.TrashType;
import com.chupinadventure.hackathon.global.PointAndRadius;
import com.chupinadventure.hackathon.presentation.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

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

    @Test
    void name() {
        service.create("userId1", new TrashCreateCommand(new Location(127.212455796659185, 37.878589738260535), TrashType.CAN));

        final PointAndRadius pointAndRadius = new PointAndRadius(37.878589738260535, 127.212455796659185, 1);
        final Set<Long> distanceSphere = repository.findDistanceSphere(pointAndRadius.getLongitude(), pointAndRadius.getLatitude(), pointAndRadius.getRadiusMeter());
        distanceSphere.size();
    }
}