package com.mbamistore.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponse {
    private boolean inStock;
    private String sku; // sku or productCode
    private int quantity;
    private String name;
    private Double price;
    private Float coOrdinateX;
    private Float coOrdinateY;
    private Float reOrderLevel; // can be integer or float for weighable items
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String deletedBy;
    private String createdBy; // useId
    private String updatedBy;
    private String availability;
    private String currency;
    private String status; // active, inactive, deleted
}
