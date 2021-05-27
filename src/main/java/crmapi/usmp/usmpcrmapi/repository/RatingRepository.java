package crmapi.usmp.usmpcrmapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer>{
    
}