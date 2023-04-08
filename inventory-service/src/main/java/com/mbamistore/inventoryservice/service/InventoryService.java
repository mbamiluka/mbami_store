package com.mbamistore.inventoryservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbamistore.inventoryservice.dto.InventoryRequest;
import com.mbamistore.inventoryservice.dto.InventoryResponse;
import com.mbamistore.inventoryservice.model.Inventory;
import com.mbamistore.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skus) {
        /**
         * This method checks if a list of products are in stock.
         * The method uses the InventoryRepository to get the quantity of each product.
         * 
         * @param skus The list of skus of the products to check.
         * @return The list of InventoryResponse objects
         * @see InventoryResponse
         * @see InventoryRepository
         * @see Inventory
         * 
         * @author MBAMI
         * @version 1.0
         * @since 2020-12-01
         */
        return inventoryRepository.findBySku(skus).stream()
                .map(inventory -> InventoryResponse.builder()
                        .sku(inventory.getSku())
                        .inStock(inventory.getQuantity() > 0)
                        .build())
                .toList();
    }

    @Transactional
    public void updateQuantity(String sku, Integer quantity) {
        /**
         * This method updates the quantity of a product.
         * The method uses the InventoryRepository to update the quantity of a product.
         * 
         * @param sku The sku of the product to update.
         * @param quantity The new quantity of the product.
         * @return void
         * @see InventoryRepository
         * @see Inventory
         * 
         * @author MBAMI
         * @version 1.0
         * @since 2020-12-01
         */
        Inventory inventory = inventoryRepository.findBySku(sku).orElseThrow(() -> new RuntimeException("Product with sku " + sku + " does not exist"));
        inventory.setQuantity(inventory.getQuantity() - quantity);
        inventoryRepository.save(inventory);
    }


    @Transactional
    public void createInventory(InventoryRequest inventoryRequest) {
        /**
         * This method creates a new product.
         * The method uses the InventoryRepository to create a new product.
         * 
         * @param inventoryRequest The InventoryRequest object.
         * @return void
         * @see InventoryRequest
         * @see InventoryRepository
         * @see Inventory
         * 
         * @author MBAMI
         * @version 1.0
         * @since 2020-12-01
         */
        Inventory inventory = new Inventory();
        inventory.setSku(inventoryRequest.getSku());
        inventory.setName(inventoryRequest.getName());
        inventory.setPrice(inventoryRequest.getPrice());
        inventory.setCurrency(inventoryRequest.getCurrency());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setStatus(inventoryRequest.getStatus());
        inventory.setAvailability(inventoryRequest.getAvailability());
        inventory.setCoOrdinateX(inventoryRequest.getCoOrdinateX());
        inventory.setCoOrdinateY(inventoryRequest.getCoOrdinateY());
        inventory.setReOrderLevel(inventoryRequest.getReOrderLevel());
        inventory.setCreatedBy(inventoryRequest.getCreatedBy());
        inventory.setCreatedAt(inventoryRequest.getCreatedAt());
        inventory.setUpdatedAt(inventoryRequest.getUpdatedAt());
        inventoryRepository.save(inventory);
    }
}
