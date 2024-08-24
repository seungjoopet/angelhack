package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.Trash;
import com.chupinadventure.hackathon.domain.TrashRepository;
import com.chupinadventure.hackathon.global.PointAndRadius;
import com.chupinadventure.hackathon.utils.GeoUtils;
import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@AllArgsConstructor
@Service
public class TrashService {

    private final TrashRepository repository;

    @Transactional
    public void create(final String userId, final TrashCreateCommand command) {
        final Trash trash = Trash.of(userId, command);
        repository.save(trash);
    }

    @Transactional(readOnly = true)
    public Set<Trash> findTrashes(final TrashCoordinateQueryCommand command) {
        final PointAndRadius pointAndRadius = GeoUtils.calculate(command.getNorth(), command.getSouth(),
                command.getEast(), command.getWest());

        final Set<Long> ids = repository.findDistanceSphere(pointAndRadius.getLongitude(),
                pointAndRadius.getLatitude(), pointAndRadius.getRadiusMeter());

        return ImmutableSet.copyOf(repository.findAllById(ids));
    }
}
