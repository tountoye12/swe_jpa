package com.diallo.exo1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Order_date", nullable = false)
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name="Customer_ID", referencedColumnName = "id")
    private Customer customer;

    public Order(LocalDate orderDate, Customer customer_id) {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customer_id=" + customer.toString() +
                '}';
    }
}
