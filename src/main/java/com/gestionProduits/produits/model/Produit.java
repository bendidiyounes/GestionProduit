package com.gestionProduits.produits.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    private String description;

    private String image;

    private String category;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "internalReference")
    private String internalReference;

    private Integer shellId;

    @Enumerated(EnumType.STRING)
    @Column(name = "inventoryStatus", nullable = false)
    private InventoryStatus inventoryStatus;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;

    @Column(name = "createdAt", updatable = false)
    private Timestamp createdAt;

    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    // Enumération pour InventoryStatus
    public enum InventoryStatus {
        INSTOCK, LOWSTOCK, OUTOFSTOCK
    }
}
