package lk.ijse.helloshoesbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockEntity {
    @Id
    private String stockId;

    private Date supplierOrderDate;
    private int quantity;
    private Double unitBuyingPrice;
    private Double unitSellingPrice;

    @ManyToOne
    @JsonIgnoreProperties("stockEntities")
    @JoinColumn(name = "supplierCode",nullable = false)
    private SupplierEntity supplierEntity;

    @ManyToOne
    @JsonIgnoreProperties("stockEntities")
    @JoinColumn(name = "itemCode",nullable = false)
    private ItemEntity itemEntity;

    @ManyToOne
    @JoinColumn(name = "branchId",nullable = false)
    private BranchEntity branchEntity;

    @ManyToOne
    @JoinColumn(name = "sizeCode",nullable = false)
    private SizeEntity sizeEntity;}
