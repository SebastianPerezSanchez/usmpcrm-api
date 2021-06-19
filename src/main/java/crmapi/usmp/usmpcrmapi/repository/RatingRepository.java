package crmapi.usmp.usmpcrmapi.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer>{
    
    @Query("select to_char(avg(tr.rateit), 'FM999999999.00') as average from Rating tr")
    List<Map<String,Object>> queryAvgRating();

    @Query("select concat(tr.rateit , ' stars') as rating, count(tr.rateit) as count from Rating tr group by rateit order by rateit")
    List<Map<String,Object>> queryNumberRating();

    @Query("select concat(to_char(tr.date ,'Mon'),'-' ,extract(year from tr.date)) as date, to_char(avg(tr.rateit), 'FM999999999.00') as average from Rating tr where tr.date > current_date - 365 group  by  extract(year from tr.date), extract(month from tr.date),to_char(tr.date ,'Mon') order by extract(year from tr.date), extract(month from tr.date)")
    List<Map<String, Object>> queryAvgRatingMonth();

    @Query("select concat(tr.rateit , ' stars') as rating, count(tr.rateit) as count from Rating tr where extract(month from tr.date) = extract(month from current_date) and extract(year from tr.date) = extract(year from current_date) group by rateit order by rateit")
    List<Map<String, Object>> queryNumberMonth();

    @Query("select to_char(avg(tr.rateit), 'FM999999999.00') as average from Rating tr where extract(month from tr.date) = extract(month from current_date) and extract(year from tr.date) = extract(year from current_date)")
    List<Map<String, Object>> queryAvgThisMonth();
}