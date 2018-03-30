package com.myretail.myretailservice.controller

import com.myretail.myretailservice.model.Product
import com.myretail.myretailservice.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification


class ProductControllerSpec extends Specification {

    ProductService productService = Mock()
    ProductController productController = new ProductController(productService)

    def "Test - getByID"() {
        given:
        int id = 1
        Product product = new Product()

        when:
        ResponseEntity<Product> response = productController.getByID(id)

        then:
        1 * productService.getById(id) >> product
        0 * _

        and:
        response.getBody() == product
        response.statusCode == HttpStatus.OK
    }

    def "Test - addProduct"() {
        given:
        int id = 1
        Product product = new Product()
        Product addProduct
        when:
        ResponseEntity<HttpStatus> response = productController.addProduct(product, id)

        then:
        1 * productService.save({ addProduct = it })
        0 * _

        and:
        addProduct.id == id
        response.statusCode == HttpStatus.CREATED
    }
}