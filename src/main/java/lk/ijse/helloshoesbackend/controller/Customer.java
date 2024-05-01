package lk.ijse.helloshoesbackend.controller;

import lk.ijse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.helloshoesbackend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class Customer {

    private final CustomerService customerService;
    @GetMapping("/health")
    public String healthCheck(){
        return "Hello I'm Customer Controller. I'm OK! Have a nice day!";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<?> getCustomer(@PathVariable ("id") String id){
       return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @DeleteMapping(value = "/{id}",produces = "application/json")
    public boolean deleteCustomer(@PathVariable("id") String id){
        return customerService.deleteCustomer(id);
    }

    @PatchMapping("/update")
    public boolean updateCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.updateCustomer(customerDTO.getCustomer_code(),customerDTO);
    }
}
