package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "occassion")
public class OccasionEntity {
    @Id
    private String occasionCode;
    private String occasionDesc;
    @OneToMany(mappedBy = "occasionEntity",cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntities;
}
