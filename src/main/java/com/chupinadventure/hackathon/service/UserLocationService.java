package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.UserLocation;
import com.chupinadventure.hackathon.domain.UserLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class UserLocationService {

    private final UserLocationRepository userLocationRepository;

    @Transactional
    public void create(final UserLocationCreateCommand command) {
        final UserLocation userLocation = UserLocation.of(command);
        userLocationRepository.save(userLocation);
    }
}
