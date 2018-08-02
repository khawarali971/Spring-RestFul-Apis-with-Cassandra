package com.cassandra.test.restful.service;

import java.util.List;
import com.cassandra.test.restful.entity.Product;

public interface Productservice {
	List<Product> getAllProducts();
	Product getProductById(Long id);
	Product create(Product product);
	Product update(Product product);
	Product findData(Long id);
	Product deleteData(Long id);
	Product deleteAllData();
	
}
