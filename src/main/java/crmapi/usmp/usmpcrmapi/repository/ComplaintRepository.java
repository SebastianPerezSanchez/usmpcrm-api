package crmapi.usmp.usmpcrmapi.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Integer>{

    @Query("select concat(to_char(tco.date ,'Mon'),'-',extract(year from tco.date)) as date, count(*) as complaints from Complaint tco where tco.date >= CURRENT_DATE - 365   group by extract(year from tco.date), extract(month from tco.date),to_char(tco.date ,'Mon') order by extract(year from tco.date), extract(month from tco.date)")
    List<Map<String,Object>> queryComplaintsMonth();

    @Query("select count(*) as complaints from Complaint")
    List<Map<String,Object>> queryComplaintsAll();

    @Query("select count(*) as complaints from Complaint c where extract(month from c.date) = extract(month from current_date) and extract(year from c.date) = extract(year from current_date)")
    List<Map<String,Object>> queryComplaintsthisMonth();
}