package de.cl.playground.spring.jpa.persistence.repository;

import de.cl.playground.spring.jpa.persistence.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Long> {



}
