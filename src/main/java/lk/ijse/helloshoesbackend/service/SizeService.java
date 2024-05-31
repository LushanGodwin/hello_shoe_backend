package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.SizeDTO;

import java.util.List;

public interface SizeService {
    void saveSize(SizeDTO sizeDTO);

    List<SizeDTO> getAllSizes();

    void updateSize(String id, SizeDTO sizeDTO);

    void deleteSize(String id);

    String getSizeId();
}
