package lk.ijse.helloshoesbackend.controller;

import lk.ijse.helloshoesbackend.dto.GenderDTO;
import lk.ijse.helloshoesbackend.dto.OccasionDTO;
import lk.ijse.helloshoesbackend.dto.VarietyDTO;
import lk.ijse.helloshoesbackend.service.GenderService;
import lk.ijse.helloshoesbackend.service.OccasionService;
import lk.ijse.helloshoesbackend.service.VarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class Inventory {
    private final GenderService genderService;
    private final OccasionService occasionService;
    private final VarietyService varietyService;

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

    @PostMapping("/saveOccasion")
    public void saveOccasion(@RequestBody OccasionDTO occasionDTO){
        occasionService.saveOccasion(occasionDTO);
    }

    @GetMapping("/getAllOccasion")
    public ResponseEntity<?> getAllOccasion(){
        return ResponseEntity.ok(occasionService.getAllOccasion());
    }

    @PatchMapping(value = "/{id}")
    public void updateOccasion(@PathVariable ("id") String id,@RequestBody OccasionDTO occasionDTO){
        occasionService.updateOccasion(id,occasionDTO);
    }

    @DeleteMapping(value = "/{id}",produces = "application/json")
    public boolean deleteOccasion(@PathVariable ("id") String id){
        return occasionService.deleteOccasion(id);
    }

    public void saveVariety(@RequestBody VarietyDTO varietyDTO){
        varietyService.saveVariety(varietyDTO);
    }

    @GetMapping("/getAllVariety")
    public ResponseEntity<?> getAllVariety(){
        return ResponseEntity.ok(varietyService.getAllVariety());
    }

    @PatchMapping(value = "/{id}")
    public void updateVariety(@PathVariable ("id") String id,@RequestBody VarietyDTO varietyDTO){
        varietyService.updateVariety(id,varietyDTO);
    }

    @DeleteMapping(value = "/{id}",produces = "application/json")
    public boolean deleteVariety(@PathVariable ("id") String id){
        return varietyService.deleteVariety(id);
    }
}
