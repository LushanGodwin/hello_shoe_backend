package lk.ijse.helloshoesbackend.repository;

import lk.ijse.helloshoesbackend.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDao extends JpaRepository<ItemEntity,String > {
    @Query("SELECT item_code FROM ItemEntity  WHERE item_code LIKE CONCAT(:prefix, '%') ORDER BY item_code DESC")
    String findLastItemCodeStartingWithPrefix(@Param("prefix") String prefix);
}
