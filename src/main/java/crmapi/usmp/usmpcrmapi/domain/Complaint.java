package crmapi.usmp.usmpcrmapi.domain;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Order orderID;

    @PrePersist
    void addTimestamp() {
    date = ZonedDateTime.now();
    }


}