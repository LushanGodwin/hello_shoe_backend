package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "stockSizeOrderDetails")
public class StockSizeOrderDetailsEntity {
    @Id
    private String stockOrderDetailsId;
    private int qty;

    @ManyToOne
    @JoinColumn(name = "stockId",nullable = false)
    private StockEntity stockEntity;

    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    private OrderEntity orderEntity;

}
