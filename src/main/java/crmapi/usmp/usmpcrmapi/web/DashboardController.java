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
        
        @GetMapping(value = "/customer/all", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String, Object>>> customersAll(){
            return new ResponseEntity<List<Map<String, Object>>>(
            customerData.queryAllCustomers(), HttpStatus.OK);
        }

        @GetMapping(value="/customer/month", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String,Object>>> customersPerMonth(){
            return new ResponseEntity<List<Map<String,Object>>>(
                customerData.queryByCustomersMonth(), HttpStatus.OK);
        }

        @GetMapping(value="/customer/age", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String,Object>>> customersAge(){
            return new ResponseEntity<List<Map<String,Object>>>(
                customerData.queryCustomersAgeRange(), HttpStatus.OK);
        }
        
        @GetMapping(value = "/customer/thismonth", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String,Object>>> customersthisMonth(){
            return new ResponseEntity<List<Map<String,Object>>>(
                customerData.queryCustomersthisMonth(), HttpStatus.OK);
        }


        @GetMapping(value ="/complaint/all", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String, Object>>> complaintsAll(){
            return new ResponseEntity<List<Map<String, Object>>>(
                complaintData.queryComplaintsAll(), HttpStatus.OK);
        }

        @GetMapping(value = "/complaint/month", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String, Object>>> complaintsPerMonth(){
            return new ResponseEntity<List<Map<String,Object>>>(
                complaintData.queryComplaintsMonth(), HttpStatus.OK);
        }

        @GetMapping(value = "/complaint/thismonth", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String, Object>>> complaintsThisMonth(){
            return new ResponseEntity<List<Map<String, Object>>>(
                complaintData.queryComplaintsthisMonth(), HttpStatus.OK);
        }

        @GetMapping(value = "/rating/avg", produces =  MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String,Object>>> ratingsAVG(){
            return new ResponseEntity<List<Map<String,Object>>>(
                ratingData.queryAvgRating(), HttpStatus.OK);
        }

        @GetMapping(value = "/rating/avgmonth", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String,Object>>> ratingAVGperMonth(){
            return new ResponseEntity<List<Map<String,Object>>>(
                ratingData.queryAvgRatingMonth(), HttpStatus.OK);
        }

        @GetMapping(value = "/rating/avgthismonth", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String,Object>>> ratingAVGthisMonth(){
            return new ResponseEntity<List<Map<String,Object>>>(
                ratingData.queryAvgThisMonth(), HttpStatus.OK);
        }
        
        @GetMapping(value = "/rating/number", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String,Object>>> ratingsNumber() {
            return new ResponseEntity<List<Map<String,Object>>>(
                ratingData.queryNumberRating(), HttpStatus.OK);
        }

        @GetMapping(value = "/rating/month", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Map<String,Object>>> ratingNumberthisMonth(){
            return new ResponseEntity<List<Map<String,Object>>>(
                ratingData.queryNumberMonth(), HttpStatus.OK);
        }


}
