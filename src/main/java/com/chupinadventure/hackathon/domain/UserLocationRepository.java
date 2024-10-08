package com.chupinadventure.hackathon.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserLocationRepository extends CrudRepository<UserLocation, Long> {

    Set<UserLocation> findAllByCollectId(final long id);
}
