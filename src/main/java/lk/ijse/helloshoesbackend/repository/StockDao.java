package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<StockEntity,String> {
    StockEntity findFirstByOrderByStockIdDesc();
}
