package com.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    @Column(name="seller_id")
    private int sellerId;

    @Column(name="seller_name")
    private String sellerName;

    public int getSellerId() { return sellerId; }
    public void setSellerId(int sellerId) { this.sellerId = sellerId; }

    public String getSellerName() { return sellerName; }
    public void setSellerName(String sellerName) { this.sellerName = sellerName; }

    public Seller() {}
}
