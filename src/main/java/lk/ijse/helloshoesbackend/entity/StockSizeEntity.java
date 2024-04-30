package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stockSize")
public class StockSizeEntity {
    @Id
    private String stockSizeId;
    private int qty;
    private Double unitBuyingPrice;
    private Double unitSellingPrice;
    private Double profit;
    private Double profitMargin;

    @ManyToOne
    @JoinColumn(name = "stockId",nullable = false)
    private StockEntity stockEntity;

    @ManyToOne
    @JoinColumn(name = "sizeCode",nullable = false)
    private SizeEntity sizeEntity;

    @OneToMany(mappedBy = "stockSizeEntity",cascade = CascadeType.ALL)
    private List<StockSizeOrderDetailsEntity> stockSizeOrderDetailsEntities;
}
