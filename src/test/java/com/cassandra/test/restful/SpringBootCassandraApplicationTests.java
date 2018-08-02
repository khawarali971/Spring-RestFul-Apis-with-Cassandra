package com.cassandra.test.restful;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.cassandra.test.restful.Repository.ProductRepository;
import com.cassandra.test.restful.entity.Product;
import com.github.javafaker.Faker;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCassandraApplicationTests {

	@Autowired
	ApplicationContext context;
	@Test
	public void contextLoads() {
		Faker faker = new Faker();
		
		ProductRepository repos = context.getBean(ProductRepository.class);
		for(int i =0 ; i <3000000; i++) {
			Product product = new Product();
//			Product getAllProduct = repos.getAllProducts();
			product.setId(faker.number().randomNumber());
			product.setName(faker.book().title());
			product.setDescription(faker.book().publisher());
			product.setPrice(faker.number().randomDigit());
			repos.save(product);
		}
		System.out.println("task completed");
			
		
	}

}
