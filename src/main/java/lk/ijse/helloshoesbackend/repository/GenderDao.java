package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderDao extends JpaRepository<GenderEntity,String> {
}
