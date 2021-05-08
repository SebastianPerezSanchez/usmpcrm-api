package crmapi.usmp.usmpcrmapi.web;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import crmapi.usmp.usmpcrmapi.domain.Order;
import crmapi.usmp.usmpcrmapi.repository.OrderRepository;

@RestController
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> orders() {
        return new ResponseEntity<List<Order>>(
            orderRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> orders(@PathVariable int id){
        Optional<Order> optionalEntity = orderRepository.findById(id);
        if(optionalEntity.isPresent()){
            return new ResponseEntity<Order>(optionalEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Order o){
        orderRepository.save(o);
        orderRepository.flush();
        return new ResponseEntity<Integer>(o.getId(),  HttpStatus.CREATED);
    }

    @PutMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> update (@RequestBody Order o){
        create(o);
        return new ResponseEntity<Order>(HttpStatus.OK);
    }
    
}
