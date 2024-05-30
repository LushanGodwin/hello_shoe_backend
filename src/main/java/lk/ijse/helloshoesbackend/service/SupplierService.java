package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);

    SupplierDTO getSupplier(String id);

    List<SupplierDTO> getAllSupplier();

    boolean deleteSupplier(String id);

    void updateSupplier(String id, SupplierDTO supplierDTO);

    String getSupplierId();
}
