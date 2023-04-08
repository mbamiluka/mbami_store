package com.mbamistore.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mbamistore.inventoryservice.model.Inventory;
import com.mbamistore.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return (args) -> {
			Inventory inventory = new Inventory();
			inventory.setInventoryId(0L);
			inventory.setSku("sku1");
			inventory.setName("name1");
			inventory.setPrice(100.0);
			inventory.setCurrency("USD");
			inventory.setQuantity(10);
			inventory.setStatus("active");
			inventory.setAvailability("available");
			inventory.setCoOrdinateX(0.0f);
			inventory.setCoOrdinateY(0.0f);
			inventory.setReOrderLevel(0.0f);
			inventory.setCreatedBy("user1");
			inventory.setCreatedAt("2021-01-01");
			inventory.setUpdatedAt("2021-05-01");
			inventoryRepository.save(inventory);
		};
	}

}
