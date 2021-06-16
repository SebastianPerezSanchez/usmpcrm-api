package crmapi.usmp.usmpcrmapi.domain;

import java.time.ZonedDateTime;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_customer")
public class Customer{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;
    private String lastname;
    private String documentID;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    private String email;
    private String address;
    private ZonedDateTime registerDate;

    @PrePersist
    void addTimestamp() {
    registerDate = ZonedDateTime.now();
    }

    /*
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Listorder orders
    */

}