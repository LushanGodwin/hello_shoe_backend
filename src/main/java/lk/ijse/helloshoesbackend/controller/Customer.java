package lk.ijse.helloshoesbackend.controller;

import lk.ijse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCustomer(@Validated @RequestBody CustomerDTO customerDTO,
                                                 BindingResult bindingResult,
                                                 @PathVariable ("id") String id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            customerService.updateCustomer(id, customerDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer Details Updated Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Customer Details Updated Unsuccessfully.\nMore Reason\n"+exception);
        }

    }

    @GetMapping("/nextCustId")
    public ResponseEntity<?> getCustomerId(){
        try {
            System.out.println(customerService.getCustomerId());
            return ResponseEntity.ok(customerService.getCustomerId());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Customer Id fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }
}
