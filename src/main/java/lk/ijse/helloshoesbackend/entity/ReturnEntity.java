package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "returns")
public class ReturnEntity {
    @Id
    private String returnId;
    private Timestamp returnDate;
    @OneToOne(cascade = CascadeType.ALL)
    private StockSizeOrderDetailsEntity stockSizeOrderDetailsEntity;
    private int qty;
}
