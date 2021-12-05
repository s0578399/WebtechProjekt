package de.htwberlin.webtech.webtech.persistence;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "order_details")
public class OrderDetails {
    private static final String SEQ_NAME = "order_details_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private BigDecimal amount;
    private BigDecimal price;



}
