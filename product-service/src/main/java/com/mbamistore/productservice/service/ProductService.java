package com.mbamistore.productservice.service;

import org.springframework.stereotype.Service;
import com.mbamistore.productservice.dto.ProductRequest;
import com.mbamistore.productservice.model.Product;
import com.mbamistore.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.stream.Collectors;
import com.mbamistore.productservice.dto.ProductResponse;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .category(productRequest.getCategory())
            .image(productRequest.getImage())
            .price(productRequest.getPrice())
            .quantity(productRequest.getQuantity())
            .sellerId(productRequest.getSellerId())
            .build();
        productRepository.save(product);
        log.info("Product created: {}", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(product -> ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .category(product.getCategory())
            .image(product.getImage())
            .price(product.getPrice())
            .quantity(product.getQuantity())
            .sellerId(product.getSellerId())
            .build()).collect(Collectors.toList());
    }
}
