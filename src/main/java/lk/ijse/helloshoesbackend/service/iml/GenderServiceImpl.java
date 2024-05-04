package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.GenderDTO;
import lk.ijse.helloshoesbackend.repository.GenderDao;
import lk.ijse.helloshoesbackend.service.GenderService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GenderServiceImpl implements GenderService {

    private final GenderDao genderDao;
    private final Mapping mapping;
    @Override
    public void saveGender(GenderDTO genderDTO) {
        genderDao.save(mapping.toGenderEntity(genderDTO));
    }

    @Override
    public List<GenderDTO> getAllGender() {
        return mapping.toGenderDTOList(genderDao.findAll());
    }

    @Override
    public void updateGender(String id, GenderDTO genderDTO) {
        genderDao.save(mapping.toGenderEntity(genderDTO));
    }

    @Override
    public boolean deleteGender(String id) {
        genderDao.deleteById(id);
        return true;
    }
}
