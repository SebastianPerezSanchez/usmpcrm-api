package crmapi.usmp.usmpcrmapi.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer>{
    
    @Query("select avg(tr.rateit) as average from Rating tr")
    List<Map<String,Object>> queryAvgRating();

    @Query("select tr.rateit as rating, count(tr.rateit) as count from Rating tr group by tr.rateit order by tr.rateit")
    List<Map<String,Object>> queryNumberRating();

}