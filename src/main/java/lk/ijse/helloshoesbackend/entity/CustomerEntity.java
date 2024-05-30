package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoesbackend.Enum.Gender;
import lk.ijse.helloshoesbackend.Enum.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class CustomerEntity {

    @Id
    private String customerCode;

    private String customer_name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @Enumerated(EnumType.STRING)
    private Level level;

    private Integer totalPoints;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String address_line_01;

    private String address_line_02;

    private String address_line_03;

    private String address_line_04;

    private String postalCode;

    private String contact;

    private String email;

    private Timestamp purchase_time_date;

    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntities;
}
