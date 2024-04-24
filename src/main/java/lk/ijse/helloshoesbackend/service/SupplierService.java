package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);

    SupplierDTO getSupplier(String id);

    List<SupplierDTO> getAllSupplier();

    boolean deleteSupplier(String id);

    boolean updateSupplier(String id, SupplierDTO supplierDTO);

}
