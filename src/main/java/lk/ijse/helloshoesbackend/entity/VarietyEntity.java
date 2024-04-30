package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "varietyEntity")
public class VarietyEntity {
    @Id
    private String varietyCode;
    private String varietyDesc;
    @OneToMany(mappedBy = "varietyEntity",cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntities;
}
