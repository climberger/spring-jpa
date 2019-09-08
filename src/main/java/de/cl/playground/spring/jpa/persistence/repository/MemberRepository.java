package de.cl.playground.spring.jpa.persistence.repository;

import de.cl.playground.spring.jpa.persistence.entity.MemberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<MemberEntity, Long> {

//    Optional<MemberEntity> findAd

}