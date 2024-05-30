package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository<SupplierEntity,String> {
    SupplierEntity findFirstByOrderBySupplierCodeDesc();
}
