package com.mbamistore.inventoryservice.model;

import java.util.Date;

import com.mbamistore.inventoryservice.dto.InventoryResponse.InventoryResponseBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    private String sku;
    private String name;
    private Double price;
    private Float coOrdinateX;
    private Float coOrdinateY;
    private Float reOrderLevel; // can be integer or float for weighable items
    private String createdAt;
    private String updatedAt;
    private Date deletedAt;
    private String createdBy; // useId
    private String updatedBy;
    private String deletedBy;
    private String availability; // available, unavailable, deleted
    private String currency;
    private Integer quantity;
    private String status; // active, inactive, deleted
    public static InventoryResponseBuilder builder() {
        return null;
    }
}
