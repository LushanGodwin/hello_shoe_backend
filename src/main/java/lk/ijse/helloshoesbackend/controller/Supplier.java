package lk.ijse.helloshoesbackend.controller;

import lk.ijse.helloshoesbackend.dto.SupplierDTO;
import lk.ijse.helloshoesbackend.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
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

    @PatchMapping(value = "/update")
    public boolean updateSupplier(@RequestBody SupplierDTO supplierDTO){
        return supplierService.updateSupplier(supplierDTO.getSupplier_code(), supplierDTO);
    }
}
