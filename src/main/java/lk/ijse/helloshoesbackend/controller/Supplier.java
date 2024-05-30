package lk.ijse.helloshoesbackend.controller;

import lk.ijse.helloshoesbackend.dto.SupplierDTO;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class Supplier {

    private final SupplierService supplierService;

    @GetMapping("/health")
    public String SupplierCheck(){
        return "Hello I'm Supplier Controller. I'm OK! Have a nice day!";
    }

    @PostMapping()
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO){
        return supplierService.saveSupplier(supplierDTO);
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<?> getSupplier(@PathVariable ("id") String id){
        return ResponseEntity.ok(supplierService.getSupplier(id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllSupplier(){

        return ResponseEntity.ok(supplierService.getAllSupplier());
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public boolean deleteSupplier(@PathVariable ("id") String id){
        return supplierService.deleteSupplier(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCustomer(@Validated @RequestBody SupplierDTO supplierDTO,
                                                 BindingResult bindingResult,
                                                 @PathVariable ("id") String id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            supplierService.updateSupplier(id,supplierDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Supplier Details Updated Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Supplier Details Updated Unsuccessfully.\nMore Reason\n"+exception);
        }

    }

    @GetMapping("/nextSupId")
    public ResponseEntity<?> getSupplierId(){
        try {
            System.out.println(supplierService.getSupplierId());
            return ResponseEntity.ok(supplierService.getSupplierId());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Customer Id fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }
}
