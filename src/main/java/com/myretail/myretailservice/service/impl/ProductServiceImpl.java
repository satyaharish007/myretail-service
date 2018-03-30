package com.myretail.myretailservice.service.impl;

import com.myretail.myretailservice.model.Product;
import com.myretail.myretailservice.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl(MongoTemplate mongoTemplate, RestTemplate restTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.restTemplate = restTemplate;
    }

    private final MongoTemplate mongoTemplate;
    private final RestTemplate restTemplate;
    private final String PRODUCT_NAME_URL = "http://localhost:8080/v2/pdp/tcin/";
    @Override
    public Product getById(int id) {
        Product product = mongoTemplate.findById(id, Product.class);
        if (product != null) {
            ResponseEntity<String> stringName = restTemplate.getForEntity(PRODUCT_NAME_URL + product.getId(), String.class);
            if (StringUtils.isNoneEmpty()) {
                product.setName(stringName.getBody());
            }
            return product;
        } else {
            return null;
        }
    }

    @Override
    public void save(Product product) {
        mongoTemplate.save(product);
    }

    @Override
    public String getName(int id) {
        Product product = mongoTemplate.findById(id, Product.class);
        return product != null ? product.getName() : null;
    }
}
