package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gender")
public class GenderEntity {
    @Id
    private String gender_code;
    private String gender_desc;
    @OneToMany(mappedBy = "genderEntity",cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntities;
}
