package de.cl.playground.spring.jpa.persistence.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity(name = "address")
//@Table(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "care_of")
    private String careOf;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @OneToOne()
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ToString.Exclude
    private MemberEntity member;

}
