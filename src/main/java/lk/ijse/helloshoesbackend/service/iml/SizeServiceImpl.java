package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.SizeDTO;
import lk.ijse.helloshoesbackend.entity.SizeEntity;
import lk.ijse.helloshoesbackend.exception.DuplicateException;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.repository.SizeDao;
import lk.ijse.helloshoesbackend.service.SizeService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SizeServiceImpl implements SizeService {

    private final SizeDao sizeDao;
    private final Mapping mapping;
    @Override
    public void saveSize(SizeDTO sizeDTO) {
        if (sizeDao.existsById(sizeDTO.getSizeCode())) throw new DuplicateException("Size Id Duplicate");
        sizeDao.save(mapping.toSizeEntity(sizeDTO));
    }

    @Override
    public List<SizeDTO> getAllSizes() {
        return mapping.toSizeDTOList(sizeDao.findAll());
    }

    @Override
    public void updateSize(String id, SizeDTO sizeDTO) {
        if (!sizeDao.existsById(id)) throw new NotFoundException("Size Not Found");
        sizeDao.save(mapping.toSizeEntity(sizeDTO));
    }

    @Override
    public void deleteSize(String id) {
        if (!sizeDao.existsById(id)) throw new NotFoundException("Size Not Found");
        sizeDao.deleteById(id);
    }

    @Override
    public String getSizeId() {
        return getNextSizeId();
    }

    private String getNextSizeId() {
        SizeEntity firstByOrderBySizeCodeDesc = sizeDao.findFirstByOrderBySizeCodeDesc();
        return (firstByOrderBySizeCodeDesc != null)
                ? String.format("Size-%03d",
                Integer.parseInt(firstByOrderBySizeCodeDesc.getSizeCode().
                        replace("Size-", "")) + 1)
                : "Size-001";
    }
}
