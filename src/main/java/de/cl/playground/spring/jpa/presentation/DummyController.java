package de.cl.playground.spring.jpa.presentation;

import de.cl.playground.spring.jpa.persistence.entity.AddressEntity;
import de.cl.playground.spring.jpa.persistence.entity.MemberEntity;
import de.cl.playground.spring.jpa.persistence.repository.AddressRepository;
import de.cl.playground.spring.jpa.persistence.repository.MemberRepository;
import de.cl.playground.spring.jpa.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DummyController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DummyService dummyService;

    @GetMapping("/execute")
    public ResponseEntity<String> execute() {
//        Optional<MemberEntity> foundOpt = memberRepository.findById(1l);
//        MemberEntity found = foundOpt.get();
//        System.out.println(found);
//        System.out.println(found.getAddress());
//        System.out.println(found.getAddress().getMember());
//
//        Optional<AddressEntity> addOpt = addressRepository.findOneByMember_Id(found.getId());
//        addOpt.ifPresent(addressEntity -> System.out.println("address found:\n" + addressEntity));


        dummyService.addEventToMember();

        return ResponseEntity.ok("executed successfully");
    }

    @GetMapping("/retrieve-events")
    public ResponseEntity<String> retrieveEvents() {
        dummyService.getEventFromMember();
        return ResponseEntity.ok("succeeded");
    }

}
