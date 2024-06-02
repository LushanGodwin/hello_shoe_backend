package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.BranchDTO;

import java.util.List;

public interface BranchService {

    void saveBranch(BranchDTO branchDTO);

    List<BranchDTO> getAllBranches();
}
