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
@Table(name = "t_rating")
public class Rating {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private Double rateit;

    private String comments;

    private ZonedDateTime date;

    @PrePersist
    void addTimestamp() {
    date = ZonedDateTime.now();
    }
    //private int id
}
