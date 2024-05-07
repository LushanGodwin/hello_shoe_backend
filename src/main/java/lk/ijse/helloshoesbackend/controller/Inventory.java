package lk.ijse.helloshoesbackend.controller;

import lk.ijse.helloshoesbackend.dto.GenderDTO;
import lk.ijse.helloshoesbackend.dto.ItemDTO;
import lk.ijse.helloshoesbackend.dto.OccasionDTO;
import lk.ijse.helloshoesbackend.dto.VarietyDTO;
import lk.ijse.helloshoesbackend.service.GenderService;
import lk.ijse.helloshoesbackend.service.InventoryService;
import lk.ijse.helloshoesbackend.service.OccasionService;
import lk.ijse.helloshoesbackend.service.VarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class Inventory {
    private final GenderService genderService;

    private final OccasionService occasionService;

    private final VarietyService varietyService;

    private final InventoryService inventoryService;

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

    @PatchMapping(value = "/{genderId}")
    public void updateGender(@PathVariable ("genderId") String id,@RequestBody GenderDTO genderDTO){
        genderService.updateGender(id,genderDTO);
    }

    @DeleteMapping(value = "/{genderId}",produces = "application/json")
    public boolean deleteGender(@PathVariable ("genderId") String id){
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

    @PatchMapping(value = "/{occasionId}")
    public void updateOccasion(@PathVariable ("occasionId") String id,@RequestBody OccasionDTO occasionDTO){
        occasionService.updateOccasion(id,occasionDTO);
    }

    @DeleteMapping(value = "/{occasionId}",produces = "application/json")
    public boolean deleteOccasion(@PathVariable ("occasionId") String id){
        return occasionService.deleteOccasion(id);
    }

    @PostMapping(value = "/saveVariety",produces = "application/json")
    public void saveVariety(@RequestBody VarietyDTO varietyDTO){
        varietyService.saveVariety(varietyDTO);
    }

    @GetMapping("/getAllVariety")
    public ResponseEntity<?> getAllVariety(){
        return ResponseEntity.ok(varietyService.getAllVariety());
    }

    @PatchMapping(value = "/{varietyId}")
    public void updateVariety(@PathVariable ("varietyId") String id,@RequestBody VarietyDTO varietyDTO){
        varietyService.updateVariety(id,varietyDTO);
    }

    @DeleteMapping(value = "/{varietyId}",produces = "application/json")
    public boolean deleteVariety(@PathVariable ("varietyId") String id){
        return varietyService.deleteVariety(id);
    }

    @PostMapping(produces = "application/json")
    public void saveItem(@RequestBody ItemDTO itemDTO){
        inventoryService.saveInventory(itemDTO);
    }

    @GetMapping(value = "/{getItem}")
    public ResponseEntity<?> getItem(@PathVariable ("getItem") String id){
        return ResponseEntity.ok(inventoryService.getItem(id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllItem(){
        return ResponseEntity.ok(inventoryService.getAllItem());
    }

    @PatchMapping(value = "/{updateItem}")
    public void updateItem(@PathVariable ("updateItem") String id, @RequestBody ItemDTO itemDTO){
        inventoryService.updateItem(id,itemDTO);
    }

    @PatchMapping("/{deleteItem}")
    public void deleteItem(@PathVariable ("deleteItem") String id){
        inventoryService.deleteItem(id);
    }
}
