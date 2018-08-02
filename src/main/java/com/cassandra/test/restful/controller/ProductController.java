package com.cassandra.test.restful.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassandra.test.restful.entity.Product;
import com.cassandra.test.restful.service.Productservice;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private Productservice productService;

	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> getProducts = productService.getAllProducts();
		if (getProducts == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(getProducts, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductsById(@PathVariable long id) {
		Product getProduct = productService.getProductById(id);
		if (getProduct == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(getProduct, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Product> createProducts(@RequestBody Product product) {
		Product createProduct = productService.create(product);
		return new ResponseEntity<>(createProduct, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		Product findproductId = productService.findData(id);
		if (findproductId == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		Product updatedproduct = productService.update(product);
		return new ResponseEntity<>(updatedproduct, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> productProduct(@PathVariable("id") Long id) {
		Product findproductId = productService.findData(id);
		if (findproductId == null)
			return new ResponseEntity<>("Id not found", HttpStatus.NO_CONTENT);
		Product deleteData = productService.deleteData(id);
		return new ResponseEntity<>("data is deleted", HttpStatus.OK);
	}

	@DeleteMapping("/deleteall")
	public ResponseEntity<String> deleteAllProducts() {
		Product deleteData = productService.deleteAllData();
		return new ResponseEntity<>("All data have been deleted!", HttpStatus.OK);
	}
}
