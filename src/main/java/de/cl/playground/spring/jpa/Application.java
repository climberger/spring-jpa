package de.cl.playground.spring.jpa;

import de.cl.playground.spring.jpa.persistence.entity.MemberEntity;
import de.cl.playground.spring.jpa.persistence.repository.EventRepository;
import de.cl.playground.spring.jpa.persistence.repository.MemberRepository;
import de.cl.playground.spring.jpa.service.DummyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(DummyService serve, MemberRepository mbRepo, EventRepository evtRepo) throws Exception {
		return (String[] args) -> {
			System.out.println("Command Line Runner Started.");

			Thread.sleep(2000);

			MemberEntity member = new MemberEntity();
			member.setFirstName("member");
			member = mbRepo.save(member);

//			IntStream.range(1, 1000)
//				.forEach((i) -> {
//
//					serve.addEventToMember();
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}

//				});


//			MemberEntity member1 = new MemberEntity();
//			member1.setFirstName("member_1");
//			member1 = mbRepo.save(member1);
//
//			MemberEntity member2 = new MemberEntity();
//			member2.setFirstName("member_2");
//			member2 = mbRepo.save(member2);
//
//
//			EventEntity event1 = new EventEntity();
//			event1.setName("event_1");
//			evtRepo.save(event1);
//
//			EventEntity event2 = new EventEntity();
//			event2.setName("event_2");
//			evtRepo.save(event2);
//
//			member1.getRegisteredEvents().add(event1);
//			member1 = mbRepo.save(member1);
//
//			member1.getRegisteredEvents().add(event2);
//			member1 = mbRepo.save(member1);
//
//
//			Thread.sleep(5000);
//
//			EventEntity evt1 = member1.getRegisteredEvents().get(0);
//
//			Thread.sleep(5000);
//
//			EventEntity evt2 = member1.getRegisteredEvents().get(1);
//
//			System.out.println("end");
		};
	}

}
