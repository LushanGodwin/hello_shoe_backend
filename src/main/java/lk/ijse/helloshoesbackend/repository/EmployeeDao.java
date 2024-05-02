package lk.ijse.helloshoesbackend.repository;


import lk.ijse.helloshoesbackend.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity,String> {
    EmployeeEntity findFirstByOrderByEmployeeCodeDesc();
}
