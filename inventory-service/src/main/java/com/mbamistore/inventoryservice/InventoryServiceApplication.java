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
			inventoryRepository.save(new Inventory(null, "sku1", "name1", "description1", "price1", "currency1", "quantity1", "status1", "createdDate1", "updatedDate1"));
			inventoryRepository.save(new Inventory(null, "sku2", "name2", "description2", "price2", "currency2", "quantity2", "status2", "createdDate2", "updatedDate2"));
			inventoryRepository.save(new Inventory(null, "sku3", "name3", "description3", "price3", "currency3", "quantity3", "status3", "createdDate3", "updatedDate3"));
			inventoryRepository.save(new Inventory(null, "sku4", "name4", "description4", "price4", "currency4", "quantity4", "status4", "createdDate4", "updatedDate4"));
			inventoryRepository.save(new Inventory(null, "sku5", "name5", "description5", "price5", "currency5", "quantity5", "status5", "createdDate5", "updatedDate5"));
		};
	}

}
