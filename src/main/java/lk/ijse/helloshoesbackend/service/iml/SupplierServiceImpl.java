package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.SupplierDTO;
import lk.ijse.helloshoesbackend.entity.SupplierEntity;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.repository.SupplierDao;
import lk.ijse.helloshoesbackend.service.SupplierService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierDao supplierDao;
    private final Mapping mapping;
    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        supplierDTO.setSupplier_code(UUID.randomUUID().toString());
        return mapping.toSupplierDTO((java.util.Optional.of(supplierDao.save(mapping.toSupplierEntity(supplierDTO)))));
    }

    @Override
    public SupplierDTO getSupplier(String id) {
        if(!supplierDao.existsById(id));
        return mapping.toSupplierDTO(supplierDao.findById(id));
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return mapping.toSupplierDTOList(supplierDao.findAll());
    }

    @Override
    public boolean deleteSupplier(String id) {
        Optional<SupplierEntity> supplierEntity = supplierDao.findById(id);
        if (supplierEntity.isPresent()){
            supplierDao.delete(supplierEntity.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSupplier(String id, SupplierDTO supplierDTO) {
        Optional<SupplierEntity> supplierEntity = supplierDao.findById(id);
        if (supplierEntity.isPresent()){
            supplierEntity.get().setSupplier_name(supplierDTO.getSupplier_name());
            supplierEntity.get().setCategory(supplierDTO.getCategory());
            supplierEntity.get().setAddress_line_01(supplierDTO.getAddress_line_01());
            supplierEntity.get().setAddress_line_02(supplierDTO.getAddress_line_02());
            supplierEntity.get().setAddress_line_03(supplierDTO.getAddress_line_03());
            supplierEntity.get().setAddress_line_05(supplierDTO.getAddress_line_04());
            supplierEntity.get().setAddress_line_04(supplierDTO.getAddress_line_05());
            supplierEntity.get().setAddress_line_06(supplierDTO.getAddress_line_06());
            supplierEntity.get().setContact_no_01(supplierDTO.getContact_no_01());
            supplierEntity.get().setContact_no_02(supplierDTO.getContact_no_02());
            if (supplierDao.existsById(id)) throw new NotFoundException("Supplier not found");
            supplierDao.save(mapping.toSupplierEntity(supplierDTO));
            return true;
        }
        return false;
    }
}
