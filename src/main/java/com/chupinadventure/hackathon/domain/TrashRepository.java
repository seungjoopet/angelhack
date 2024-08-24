package com.chupinadventure.hackathon.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashRepository extends CrudRepository<Trash, Long> {
}
