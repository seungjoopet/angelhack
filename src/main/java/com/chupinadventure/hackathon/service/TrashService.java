package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.Trash;
import com.chupinadventure.hackathon.domain.TrashRepository;
import com.chupinadventure.hackathon.global.PointAndRadius;
import com.chupinadventure.hackathon.utils.GeoUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class TrashService {

    private final TrashRepository repository;

    @Transactional
    public void create(final String userId, final List<TrashCreateCommand> commands) {
        repository.saveAll(commands.stream()
                .map(command -> Trash.of(userId, command))
                .collect(ImmutableList.toImmutableList()));
    }

    @Transactional(readOnly = true)
    public Set<Trash> findTrashes(final TrashCoordinateQueryCommand command) {
        final PointAndRadius pointAndRadius = GeoUtils.calculate(command.getEast(), command.getWest(),
                command.getNorth(), command.getSouth());

        final Set<Long> ids = repository.findDistanceSphere(pointAndRadius.getLongitude(),
                pointAndRadius.getLatitude(), pointAndRadius.getRadiusMeter());

        return ImmutableSet.copyOf(repository.findAllById(ids));
    }
}
