package com.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name="order_id")
    private int orderId;

    @Column(name="customer_id")
    private int customerId;

    @Column(name="seller_id")
    private int sellerId;

    @Column(name="amount_due")
    private float amountDue;

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getSellerId() { return sellerId; }
    public void setSellerId(int sellerId) { this.sellerId = sellerId; }

    public float getAmountDue() { return amountDue; }
    public void setAmountDue(float amountDue) { this.amountDue = amountDue; }
}
