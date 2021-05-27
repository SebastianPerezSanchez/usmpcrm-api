package crmapi.usmp.usmpcrmapi.domain;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_complaint")
public class Complaint{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    
    private String subject;
    private String explanation;
    
    private ZonedDateTime date;


    /*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    */
    
    @PrePersist
    void addTimestamp() {
    date = ZonedDateTime.now();
    }


}