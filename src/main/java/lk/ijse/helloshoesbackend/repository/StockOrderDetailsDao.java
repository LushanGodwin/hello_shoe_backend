package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.entity.StockSizeOrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockOrderDetailsDao extends JpaRepository<StockSizeOrderDetailsEntity,String> {
}
