package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.BranchDTO;
import lk.ijse.helloshoesbackend.exception.InvalidException;
import lk.ijse.helloshoesbackend.repository.BranchDao;
import lk.ijse.helloshoesbackend.service.BranchService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lk.ijse.helloshoesbackend.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final Mapping mapping;

    private final BranchDao branchDao;
    @Override
    public void saveBranch(BranchDTO branchDTO) {
        if (!branchDTO.getProductCode().equals(UtilMatters.productActivationCode())) throw new InvalidException("Invalid Product Code");
        branchDTO.setBranchId(UtilMatters.generateId());
        branchDao.save(mapping.toBranchEntity(branchDTO));
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        return mapping.toBranchDTOs(branchDao.findAll());
    }
}
