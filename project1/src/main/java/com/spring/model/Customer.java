package com.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="customer_address")
    private String customerAddress;

    @Column(name="amount_due")
    private float amountDue;

    public int getCustomerId() { return customerId;}
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName;}
    public void setCustomerName(String customerName) {this.customerName = customerName; }

    public String getCustomerAddress() { return customerAddress;}
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    public float getAmountDue(){ return amountDue; }
    public void setAmountDue(float amountDue) { this.amountDue = amountDue; }
}
