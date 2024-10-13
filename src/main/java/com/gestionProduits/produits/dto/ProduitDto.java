package com.gestionProduits.produits.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDto {

    private Integer id;

    private String code;

    private String name;

    private String description;

    private String image;

    private String category;

    private BigDecimal price;

    private Integer quantity;

    private String internalReference;

    private Integer shellId;

    private InventoryStatus inventoryStatus;

    private BigDecimal rating;

    // Enumération pour InventoryStatus
    public enum InventoryStatus {
        INSTOCK, LOWSTOCK, OUTOFSTOCK
    }
}
