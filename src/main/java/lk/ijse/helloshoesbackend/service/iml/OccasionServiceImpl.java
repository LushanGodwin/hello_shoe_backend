package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.OccasionDTO;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.repository.OccasionDao;
import lk.ijse.helloshoesbackend.service.OccasionService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OccasionServiceImpl implements OccasionService {
    private final Mapping mapping;
    private final OccasionDao occasionDao;
    @Override
    public void saveOccasion(OccasionDTO occasionDTO) {
        occasionDao.save(mapping.toOccasionEntity(occasionDTO));
    }

    @Override
    public List<OccasionDTO> getAllOccasion() {
        return mapping.toOccasionDTOList(occasionDao.findAll());
    }

    @Override
    public void updateOccasion(String id, OccasionDTO occasionDTO) {
        if (!occasionDao.existsById(id)) throw new NotFoundException("Occasion not found");
        occasionDao.save(mapping.toOccasionEntity(occasionDTO));
    }

    @Override
    public boolean deleteOccasion(String id) {
        occasionDao.deleteById(id);
        return true;
    }
}
