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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crmapi.usmp.usmpcrmapi.domain.Customer;
import crmapi.usmp.usmpcrmapi.repository.CustomerRepository;

@RestController
@RequestMapping(value = "api/customer", produces = "application/jason" )
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> customers() {
        return new ResponseEntity<List<Customer>>(
            customerRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> customers(@PathVariable int id){
        Optional<Customer> optionalEntity = customerRepository.findById(id);
        if(optionalEntity.isPresent()){
            return new ResponseEntity<Customer>(optionalEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Customer c) {
        customerRepository.save(c);
        customerRepository.flush();
        return new ResponseEntity<Integer>(c.getId(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> update(@RequestBody Customer c){
        customerRepository.save(c);
        customerRepository.flush();
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> delete(@PathVariable int id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }
    
}
