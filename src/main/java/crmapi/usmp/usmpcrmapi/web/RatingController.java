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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import crmapi.usmp.usmpcrmapi.domain.Rating;
import crmapi.usmp.usmpcrmapi.repository.RatingRepository;

@RestController
@RequestMapping(value = "api/rating", produces = "application/json")
public class RatingController {

    private RatingRepository ratingRepository;

    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rating>> ratings() {
        return new ResponseEntity<List<Rating>>(
            ratingRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> customers(@PathVariable int id){
        Optional<Rating> optionalEntity = ratingRepository.findById(id);
        if(optionalEntity.isPresent()){
            return new ResponseEntity<Rating>(optionalEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Rating>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Rating r) {
        ratingRepository.save(r);
        ratingRepository.flush();
        return new ResponseEntity<Integer>(r.getId(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> update(@RequestBody Rating r){
        ratingRepository.save(r);
        ratingRepository.flush();
        return new ResponseEntity<Rating>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> delete(@PathVariable int id) {
        ratingRepository.deleteById(id);
        return new ResponseEntity<Rating>(HttpStatus.OK);
    }
    
}
