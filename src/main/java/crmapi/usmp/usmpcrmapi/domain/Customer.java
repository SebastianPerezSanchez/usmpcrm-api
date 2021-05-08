package crmapi.usmp.usmpcrmapi.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private Date birthdate;
    private String email;
    private String address;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Order> customerOrders;


}