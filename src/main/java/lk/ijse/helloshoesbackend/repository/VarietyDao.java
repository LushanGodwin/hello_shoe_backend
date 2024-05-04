package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.entity.VarietyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarietyDao extends JpaRepository<VarietyEntity,String> {
}
