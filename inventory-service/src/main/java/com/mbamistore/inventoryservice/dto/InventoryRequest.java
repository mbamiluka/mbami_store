package com.mbamistore.inventoryservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class InventoryRequest {
    private String sku;
    private Integer quantity;
    private String name;
    private Double price;
    private Float coOrdinateX;
    private Float coOrdinateY;
    private Float reOrderLevel; // can be integer or float for weighable items
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String createdBy; // useId
    private String deletedBy;
    private String updatedBy;
    private String availability; // available, unavailable, deleted
    private String currency;
    private String status; // active, inactive, deleted

}
