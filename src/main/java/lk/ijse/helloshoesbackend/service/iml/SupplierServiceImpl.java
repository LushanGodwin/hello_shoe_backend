package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.SupplierDTO;
import lk.ijse.helloshoesbackend.entity.SupplierEntity;
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
}
