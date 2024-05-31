package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.VarietyDTO;

import java.util.List;

public interface VarietyService {
    void saveVariety(VarietyDTO varietyDTO);

    List<VarietyDTO> getAllVariety();

    void updateVariety(String id, VarietyDTO varietyDTO);

    void deleteVariety(String id);
}
