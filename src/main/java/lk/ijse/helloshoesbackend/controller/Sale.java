package lk.ijse.helloshoesbackend.controller;

import lk.ijse.helloshoesbackend.dto.OrderDTO;
import lk.ijse.helloshoesbackend.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sale")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class Sale {

    final private SaleService saleService;

    @GetMapping("/nextOrderId")
    public ResponseEntity<?> getOrderId(){
        try {
            return ResponseEntity.ok(saleService.getNextOrderId());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Order Id fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveOrder(@Validated @RequestBody OrderDTO orderDTO,
                                       BindingResult bindingResult) {
        System.out.println(orderDTO.getOrderNo());
        System.out.println(orderDTO.getPaymentMethod());
        System.out.println(orderDTO.getPaidAmount());
        System.out.println(orderDTO.getBankName());
        System.out.println(orderDTO.getCustomerId());
        System.out.println(orderDTO.getId());
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            saleService.saveOrder(orderDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer Details saved Successfully.");
        } catch (Exception exception) {
            System.out.println(exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Customer saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }
}
