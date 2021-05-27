package crmapi.usmp.usmpcrmapi.web;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crmapi.usmp.usmpcrmapi.domain.Complaint;
import crmapi.usmp.usmpcrmapi.repository.ComplaintRepository;

@RestController
@RequestMapping(value = "api/complaint", produces = "application/json")
public class ComplaintController {

    private ComplaintRepository complaintRepository;

    public ComplaintController(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Complaint>> customers() {
        return new ResponseEntity<List<Complaint>>(
            complaintRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Complaint> customers(@PathVariable int id){
        Optional<Complaint> optionalEntity = complaintRepository.findById(id);
        if(optionalEntity.isPresent()){
            return new ResponseEntity<Complaint>(optionalEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Complaint>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Complaint c) {
        complaintRepository.save(c);
        complaintRepository.flush();
        return new ResponseEntity<Integer>(c.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Complaint> delete(@PathVariable int id) {
        complaintRepository.deleteById(id);
        return new ResponseEntity<Complaint>(HttpStatus.OK);
    }
    
}
