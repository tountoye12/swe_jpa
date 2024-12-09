package com.diallo.exo1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_ID", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total_price", nullable = false)
    private Integer price;

    public OrderDetails(Order order, Product product, Integer quantity, Integer price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
