package com.chupinadventure.hackathon.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TrashRepository extends CrudRepository<Trash, Long> {
    @Query(value = "SELECT id FROM trash WHERE ST_Distance_Sphere(location, ST_SRID(POINT(:latitude, :longitude), 4326)) < :radiusMeter AND is_deleted = false",
            nativeQuery = true)
    Set<Long> findDistanceSphere(@Param("longitude") final double longitude, @Param("latitude") final double latitude, @Param("radiusMeter") final double radiusMeter);
}
