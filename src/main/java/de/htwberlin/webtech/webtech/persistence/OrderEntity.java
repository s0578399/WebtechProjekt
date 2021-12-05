package de.htwberlin.webtech.webtech.persistence;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "orders")
public class OrderEntity {
    private static final String SEQ_NAME = "order_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "id")
    private long id;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private BigDecimal sum;

    private String adress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetails> details;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
