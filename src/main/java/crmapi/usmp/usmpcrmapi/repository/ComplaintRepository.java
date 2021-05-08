package crmapi.usmp.usmpcrmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Integer>{
    
}