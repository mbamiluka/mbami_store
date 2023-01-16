package com.mbamistore.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.mongodb.assertions.Assertions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc

class ProductServiceApplicationTests {
	@Container
	private static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
	@Autowired
	private MockMvc mockMvc;

	@DynamicPropertySource
	static void mongoProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateProduct() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"name\":\"test\",\"description\":\"test\",\"category\":\"test\",\"image\":\"test\",\"price\":1,\"quantity\":1,\"sellerId\":\"test\"}"))
			.andExpect(status().isCreated());
		
		Assertions.assertNotNull(mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")));
	
	}

	@Test
	void testGetAllProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products"))
			.andExpect(status().isOk());
	}

}
