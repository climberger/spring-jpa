package de.cl.playground.spring.jpa.persistence.repository;

import de.cl.playground.spring.jpa.persistence.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

}
