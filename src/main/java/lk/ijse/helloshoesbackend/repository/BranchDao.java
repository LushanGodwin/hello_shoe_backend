package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDao extends JpaRepository<BranchEntity,String> {
}
