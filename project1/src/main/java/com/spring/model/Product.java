package com.spring.model;

import jakarta.persistence.*;



@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name="product_id")
    private int productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_category")
    private String productCategory;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getProductCategory() { return productCategory; }
    public void setProductCategory(String productCategory) { this.productCategory = productCategory; }

    public Seller getSeller() { return seller; }
    public void setSeller(Seller seller) { this.seller = seller; }

    public Product() {}

}
