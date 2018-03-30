package com.myretail.myretailservice.repository;

import com.myretail.myretailservice.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer>{
}
