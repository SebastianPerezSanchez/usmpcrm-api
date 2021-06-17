package crmapi.usmp.usmpcrmapi.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Integer>{

    @Query("select count(*) as count, to_char(tco.date ,'Mon') as mon, extract(year from tco.date) as year from Complaint tco group by extract(month from tco.date),3,2 order by 3, extract(month from tco.date)")
    List<Map<String,Object>> queryComplaintsMonth();

    @Query("select count(*) as count from Complaint")
    List<Map<String,Object>> queryComplaintsAll();
}