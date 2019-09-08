package de.cl.playground.spring.jpa.persistence.repository;

import de.cl.playground.spring.jpa.persistence.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

}
