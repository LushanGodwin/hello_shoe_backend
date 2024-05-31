package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.GenderDTO;
import lk.ijse.helloshoesbackend.entity.GenderEntity;

import java.util.List;

public interface GenderService {
    void saveGender(GenderDTO genderDTO);

    List<GenderDTO> getAllGender();

    void updateGender(String id, GenderDTO genderDTO);

    void deleteGender(String id);
}
