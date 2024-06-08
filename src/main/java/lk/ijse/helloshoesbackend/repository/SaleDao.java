package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDao extends JpaRepository<OrderEntity, String> {
        OrderEntity findFirstByOrderByOrderNoDesc();
}
