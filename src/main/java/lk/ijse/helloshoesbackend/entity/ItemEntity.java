package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoesbackend.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id
    private String itemCode;
    private String itemDesc;
    @Column(columnDefinition = "LONGTEXT")
    private String pic;
    private String status;
    @ManyToOne
    @JoinColumn(name = "genderCode",nullable = false)
    private GenderEntity genderEntity;

    @ManyToOne
    @JoinColumn(name = "occasionCode",nullable = false)
    private OccasionEntity occasionEntity;

    @ManyToOne
    @JoinColumn(name = "varietyCode",nullable = false)
    private VarietyEntity varietyEntity;

    @OneToMany(mappedBy = "itemEntity",cascade = CascadeType.ALL)
    private List<StockEntity> stockEntities;}
