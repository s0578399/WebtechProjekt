package de.htwberlin.webtech.webtech.persistence;

import org.hibernate.annotations.CreationTimestamp;
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
    @Column(name = "order_id")
    private long id;

    @Column(name = "created_time")
    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "summ")
    private BigDecimal sum;

    @Column(name = "adresse")
    private String adress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> details;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEntity status;


    public OrderEntity(LocalDateTime createdTime, LocalDateTime updatedTime, UserEntity user, BigDecimal sum, String adress, List<OrderDetailsEntity> details, OrderStatusEntity status) {
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.user = user;
        this.sum = sum;
        this.adress = adress;
        this.details = details;
        this.status = status;
    }

    protected OrderEntity() {}


    public long getId() {
        return id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<OrderDetailsEntity> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailsEntity> details) {
        this.details = details;
    }

    public OrderStatusEntity getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEntity status) {
        this.status = status;
    }
}
