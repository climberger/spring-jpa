package de.cl.playground.spring.jpa.persistence;

import de.cl.playground.spring.jpa.persistence.entity.AddressEntity;
import de.cl.playground.spring.jpa.persistence.entity.MemberEntity;
import de.cl.playground.spring.jpa.persistence.repository.AddressRepository;
import de.cl.playground.spring.jpa.persistence.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void whenMemberWithAddressIsPersisted_thenMEmberAndAddressShouldBeFound() {

        // given
        MemberEntity member = new MemberEntity();
        member.setFirstName("Alex");
        AddressEntity address = new AddressEntity();
        address.setCity("Darmstadt");
        member.setAddress(address);
        address.setMember(member);
        MemberEntity saved = entityManager.persist(member);
        entityManager.flush();

        // when
        Optional<MemberEntity> foundMember = memberRepository.findById(saved.getId());
        Optional<AddressEntity> foundAddress = addressRepository.findOneByMember_Id(saved.getId());

        // then
        Consumer<MemberEntity> memberCons = (mb) -> {
            Assertions.assertThat(mb.getFirstName()).isEqualTo("Alex");
            Assertions.assertThat(mb.getAddress()).isNotNull();
            Assertions.assertThat(mb.getAddress().getMember()).isNotNull();
        };
        Assertions.assertThat(foundMember).hasValueSatisfying(memberCons);

        Consumer<AddressEntity> addCons = (add) -> {
            Assertions.assertThat(add.getCity()).isEqualTo("Darmstadt");

        };
        Assertions.assertThat(foundAddress).hasValueSatisfying(addCons);


//        Condition<MemberEntity> memberCanBeFound = new Condition<>(mb -> mb.getFirstName() == "Alex", "return Alex");
//        Condition<MemberEntity> addressIncluded = new Condition<>(mb -> mb.getAddress() != null,"Address not equal zero");
//        Consumer<MemberEntity> consumer = (mb) -> {
//            Assertions.assertThat(mb)
//        };
//        Assertions.assertThat(foundMember).hasValueSatisfying(memberCanBeFound);
//        Assertions.assertThat(foundMember).hasValueSatisfying(addressIncluded);

    }
}
