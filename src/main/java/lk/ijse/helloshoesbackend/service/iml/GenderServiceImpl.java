package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.GenderDTO;
import lk.ijse.helloshoesbackend.exception.DuplicateException;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
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
        System.out.println(genderDTO.getGenderCode()+"=========================");
        if (genderDao.existsById(genderDTO.getGenderCode())) throw new DuplicateException("Gender id Duplicate");
        genderDao.save(mapping.toGenderEntity(genderDTO));
    }

    @Override
    public List<GenderDTO> getAllGender() {
        return mapping.toGenderDTOList(genderDao.findAll());
    }

    @Override
    public void updateGender(String id, GenderDTO genderDTO) {
        if(!genderDao.existsById(id)) throw new NotFoundException("Gender Not Found");
        genderDao.save(mapping.toGenderEntity(genderDTO));
    }

    @Override
    public void deleteGender(String id) {
        if (!genderDao.existsById(id)) throw new NotFoundException("Gender Not Found");
        genderDao.deleteById(id);
    }
}
