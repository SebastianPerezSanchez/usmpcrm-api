package crmapi.usmp.usmpcrmapi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;

import crmapi.usmp.usmpcrmapi.repository.*;



@RestController
@RequestMapping(value = "api/dashboard", produces = "application/json")
public class DashboardController {

        private final CustomerRepository customerData;
        private final ComplaintRepository complaintData;
        private final RatingRepository ratingData;


            
        public DashboardController(CustomerRepository customerData, ComplaintRepository complaintData, RatingRepository ratingData){
            this.customerData = customerData;
            this.complaintData = complaintData;
            this.ratingData = ratingData;
        }

        @GetMapping(value="/customer", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<Integer,Object>>> customers(){
            return new ResponseEntity<List<Map<Integer,Object>>>(
                customerData.queryByCustomersMonth(), HttpStatus.OK);
        }

        @GetMapping(value = "/complaint", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<Integer, Object>>> complaints(){
            return new ResponseEntity<List<Map<Integer,Object>>>(
                complaintData.queryComplaintsMonth(), HttpStatus.OK);
        }

        @GetMapping(value = "/rating/avg", produces =  MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<Integer,Object>>> ratingsAVG(){
            return new ResponseEntity<List<Map<Integer,Object>>>(
                ratingData.queryAvgRating(), HttpStatus.OK);
        }
        
        @GetMapping(value = "/rating/number", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<Integer,Object>>> ratingsNumber() {
            return new ResponseEntity<List<Map<Integer,Object>>>(
                ratingData.queryNumberRating(), HttpStatus.OK);
        }
}
