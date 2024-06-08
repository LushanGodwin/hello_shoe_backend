package lk.ijse.helloshoesbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lk.ijse.helloshoesbackend.Enum.PaymentMethod;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity{
    @Id
    private String orderNo;
    private Timestamp purchasedDate;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private double totalAmount;
    private double paidAmount;
    private String bankName;
    private String bankNo;

    @ManyToOne
    @JoinColumn(name = "cutomerId",nullable = false)
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "email",nullable = false)
    private UserEntity userEntity;


}