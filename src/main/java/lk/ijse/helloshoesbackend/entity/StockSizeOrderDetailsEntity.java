package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stockSizeOrderDetails")
public class StockSizeOrderDetailsEntity {
    @Id
    private String stockSizeOrderDetailsId;
    private int qty;

    @ManyToOne
    @JoinColumn(name = "stockSizeId",nullable = false)
    private StockSizeEntity stockSizeEntity;

    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    private OrderEntity orderEntity;
}
