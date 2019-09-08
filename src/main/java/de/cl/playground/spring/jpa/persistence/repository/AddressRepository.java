package de.cl.playground.spring.jpa.persistence.repository;

import de.cl.playground.spring.jpa.persistence.entity.AddressEntity;
import de.cl.playground.spring.jpa.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

//    @Query("SELECT add FROM address add where add.member.id = :memberId")
    Optional<AddressEntity> findOneByMember_Id(/*@Param("memberId") */long memberId);


}