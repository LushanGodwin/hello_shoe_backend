package lk.ijse.helloshoesbackend.controller;

import lk.ijse.helloshoesbackend.dto.GenderDTO;
import lk.ijse.helloshoesbackend.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class Inventory {
    private final GenderService genderService;

    @GetMapping("/health")
    public String healthCheck(){
        return "Inventory Health";
    }

    @PostMapping("/saveGender")
    public void saveGender(@RequestBody GenderDTO genderDTO){
        genderService.saveGender(genderDTO);
    }

    @GetMapping("/getAllGender")
    public ResponseEntity<?> getAllGender(){
        return ResponseEntity.ok(genderService.getAllGender());
    }

    @PatchMapping(value = "/{id}")
    public void updateGender(@PathVariable ("id") String id,@RequestBody GenderDTO genderDTO){
        genderService.updateGender(id,genderDTO);
    }

    @DeleteMapping(value = "/{id}",produces = "application/json")
    public boolean deleteGender(@PathVariable ("id") String id){
        return genderService.deleteGender(id);
    }
}
