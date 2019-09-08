package de.cl.playground.spring.jpa.persistence.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "event") // Name of the entity for hql queries, if not set, classname is name of entity
//@Table(name = "member" schema="<schema>") // name of the database table. If not set, name of entity is name of the table
public class EventEntity {

    /**
     * GenerationType can be AUTO, TABLE, SEQUENCE, or IDENTITY
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    //  @Column(name="first_name", length=50, nullable=false, unique=false)
    @Column(name="name")
    private String name;

    @Column(name="start_time")
    private LocalDateTime startTime;

    @Column(name="end_time")
    private LocalDateTime endTime;

    @ManyToMany(mappedBy = "registeredEvents", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<MemberEntity> registeredParticipants  = new ArrayList<>();
}