package com.myretail.myretailservice.controller;

import com.myretail.myretailservice.model.Product;
import com.myretail.myretailservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    ResponseEntity<Product> getByID(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public
    @ResponseBody
    ResponseEntity<HttpStatus> addProduct(
            @RequestBody Product product, @PathVariable(value = "id") int id
    ) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
