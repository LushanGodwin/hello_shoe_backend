package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.VarietyDTO;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.repository.VarietyDao;
import lk.ijse.helloshoesbackend.service.VarietyService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VarietyServiceImpl implements VarietyService {
    private final VarietyDao varietyDao;
    private final Mapping mapping;

    @Override
    public void saveVariety(VarietyDTO varietyDTO) {
        varietyDao.save(mapping.toVarietyEntity(varietyDTO));
    }

    @Override
    public List<VarietyDTO> getAllVariety() {
        return mapping.toVarietyDTOList(varietyDao.findAll());
    }

    @Override
    public void updateVariety(String id, VarietyDTO varietyDTO) {
        if (!varietyDao.existsById(id)) throw new NotFoundException("Variety not found");
        varietyDao.save(mapping.toVarietyEntity(varietyDTO));
    }

    @Override
    public boolean deleteVariety(String id) {
        varietyDao.deleteById(id);
        return true;
    }
}
