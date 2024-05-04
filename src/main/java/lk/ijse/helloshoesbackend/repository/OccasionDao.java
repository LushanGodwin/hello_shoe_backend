package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.dto.OccasionDTO;
import lk.ijse.helloshoesbackend.entity.OccasionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccasionDao extends JpaRepository<OccasionEntity,String> {
}
