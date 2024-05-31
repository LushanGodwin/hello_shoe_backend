package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeDao extends JpaRepository<SizeEntity,String> {
    SizeEntity findFirstByOrderBySizeCodeDesc();
}
