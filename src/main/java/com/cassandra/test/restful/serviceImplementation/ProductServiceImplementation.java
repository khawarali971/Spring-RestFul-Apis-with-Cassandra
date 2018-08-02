package com.cassandra.test.restful.serviceImplementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cassandra.test.restful.Repository.ProductRepository;
import com.cassandra.test.restful.entity.Product;
import com.cassandra.test.restful.service.Productservice;

@Service
public class ProductServiceImplementation implements Productservice {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		List<Product> getAllProducts = productRepository.findAll();
		return getAllProducts;
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> getProductsById = productRepository.findById(id);
		return getProductsById.get();
	}

	@Override
	public Product create(Product product) {
		Product productCreate = productRepository.save(product);
		return productCreate;
	}

	@Override
	public Product update(Product product) {
		Product updateProduct = productRepository.save(product);
		return updateProduct;
	}

	@Override
	public Product findData(Long id) {
		Optional<Product> getProductsById = productRepository.findById(id);
		return getProductsById.get();
	}

	@Override
	public Product deleteData(Long id) {
		productRepository.deleteById(id);
		return null;
	}

	@Override
	public Product deleteAllData() {
		productRepository.deleteAll();
		return null;
	}

}
