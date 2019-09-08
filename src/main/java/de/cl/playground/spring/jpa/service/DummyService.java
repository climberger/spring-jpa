package de.cl.playground.spring.jpa.service;

import de.cl.playground.spring.jpa.persistence.entity.EventEntity;
import de.cl.playground.spring.jpa.persistence.entity.MemberEntity;
import de.cl.playground.spring.jpa.persistence.repository.EventRepository;
import de.cl.playground.spring.jpa.persistence.repository.MemberRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class DummyService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EventRepository eventRepository;

    public void addEventToMember() {
        EventEntity event = new EventEntity();
        event.setName(RandomStringUtils.random(6, true, false));
        MemberEntity mb = memberRepository.findById(1l).get();

        mb.getRegisteredEvents().add(event);
//        mb.setRegisteredEvents(Arrays.asList(event));
        memberRepository.save(mb);
    }

    public void getEventFromMember() {
        MemberEntity mb = memberRepository.findById(1l).get();

        List<EventEntity> events = mb.getRegisteredEvents();


        System.out.println("events retrieved");
    }

}
