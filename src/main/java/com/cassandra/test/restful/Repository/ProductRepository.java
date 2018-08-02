package com.cassandra.test.restful.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import com.cassandra.test.restful.entity.Product;
import java.lang.Long;

public interface ProductRepository extends CassandraRepository<Product, Long> {

}
