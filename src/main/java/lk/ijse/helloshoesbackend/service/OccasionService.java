package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.OccasionDTO;

import java.util.List;

public interface OccasionService {
    void saveOccasion(OccasionDTO occasionDTO);

    List<OccasionDTO> getAllOccasion();

    void updateOccasion(String id, OccasionDTO occasionDTO);

    void deleteOccasion(String id);
}
