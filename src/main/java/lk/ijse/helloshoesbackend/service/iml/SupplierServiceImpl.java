package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.SupplierDTO;
import lk.ijse.helloshoesbackend.repository.SupplierDao;
import lk.ijse.helloshoesbackend.service.SupplierService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return mapping.toSupplierDTO(java.util.Optional.of(supplierDao.save(mapping.toSupplierEntity(supplierDTO))));
    }
}
