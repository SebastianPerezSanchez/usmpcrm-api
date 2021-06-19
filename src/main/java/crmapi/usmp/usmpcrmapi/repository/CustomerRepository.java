package crmapi.usmp.usmpcrmapi.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    
    @Query("select concat(to_char(tc.registerDate,'Mon'),'-' ,extract(year from tc.registerDate)) as date, count(*) as customers from Customer tc where tc.registerDate >= CURRENT_DATE - 365 group by  extract(year from tc.registerDate), extract(month from tc.registerDate),to_char(tc.registerDate,'Mon') order by extract(year from tc.registerDate), extract(month from tc.registerDate)")
    List<Map<String, Object>> queryByCustomersMonth();

    @Query("select count(*) as customers from Customer")
    List<Map<String, Object>> queryAllCustomers();

    @Query("select count(*) as customers from Customer c where extract(month from c.registerDate) = extract(month from current_date)")
    List<Map<String, Object>> queryCustomersthisMonth();

    @Query("select concat('ejemplo') as ejemplo, sum(case when extract(year from age(tc.birthdate)) between 18 and 30 then 1 else 0 end) as a, sum(case when extract(year from age(tc.birthdate)) between 31 and 45 then 1 else 0 end) as b, sum(case when extract(year from age(tc.birthdate)) > 46 then 1 else 0 end) as c from Customer tc")
    List<Map<String, Object>> queryCustomersAgeRange();
}