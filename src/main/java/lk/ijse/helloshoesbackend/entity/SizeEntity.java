package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "sizeEntity")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SizeEntity {
    @Id
    private String sizeCode;
    private String sizeDesc;

    @OneToMany(mappedBy = "sizeEntity",cascade = CascadeType.ALL)
    private List<StockSizeEntity> stockSizeEntities;
}
