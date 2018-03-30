package com.myretail.myretailservice.service;

import com.myretail.myretailservice.model.Product;

public interface ProductService {
    Product getById(int id);

    void save(Product product);

    String getName(int id);
}
