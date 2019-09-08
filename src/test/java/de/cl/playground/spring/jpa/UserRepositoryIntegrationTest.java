package de.cl.playground.spring.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import de.cl.playground.spring.jpa.persistence.entity.MemberEntity;
import de.cl.playground.spring.jpa.persistence.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        MemberEntity user1 = new MemberEntity();
        user1.setFirstName("Bob");
        user1.setEMailAddress("bob@mail.com");
        memberRepository.save(user1);

        List<MemberEntity> users = (List<MemberEntity>) memberRepository.findAll();

        assertThat(users.size()).isEqualTo(1);
    }
}