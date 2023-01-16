package com.mbamistore.productservice.repository;

import com.mbamistore.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findBySellerId(String sellerId);
    List<Product> findByCategory(String category);
    List<Product> findByName(String name);
}