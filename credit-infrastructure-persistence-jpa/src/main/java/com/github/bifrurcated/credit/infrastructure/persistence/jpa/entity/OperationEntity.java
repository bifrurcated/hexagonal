package com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "credit_operation")
@Entity
public class OperationEntity extends BaseEntity {

    @Id
    private UUID id;

    @JoinColumn(name = "credit_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CreditEntity credit;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, length = 50)
    private String direction;

    public OperationEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CreditEntity getCredit() {
        return credit;
    }

    public void setCredit(CreditEntity credit) {
        this.credit = credit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
