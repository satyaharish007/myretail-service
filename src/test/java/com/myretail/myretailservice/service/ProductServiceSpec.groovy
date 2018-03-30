package com.myretail.myretailservice.service

import com.myretail.myretailservice.model.Product
import com.myretail.myretailservice.service.impl.ProductServiceImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class ProductServiceSpec extends Specification {

    MongoTemplate mongoTemplate = Mock()
    RestTemplate restTemplate = Mock()
    ProductService productService = new ProductServiceImpl(mongoTemplate, restTemplate)

    def "Test - getById"() {
        given:
        int id = 1
        Product product = new Product(id: id)
        String url
        String productName = "TEST PRODUCT"
        when:
        Product returnProduct = productService.getById(id)

        then:
        1 * mongoTemplate.findById(id, Product.class) >> product
        1 * restTemplate.getForEntity({ url = it }, String.class) >> new ResponseEntity<>(productName, HttpStatus.OK)
        0 * _

        and:
        returnProduct.name == productName
        url == "http://localhost:8080/v2/pdp/tcin/${id}"
    }

    def "Test - getById - not Id found"() {
        given:
        int id = 1

        when:
        Product returnProduct = productService.getById(id)

        then:
        1 * mongoTemplate.findById(id, Product.class) >> null
        0 * _

        and:
        returnProduct == null
    }

    def "Test - save"() {
        given:
        Product product = new Product()

        when:
        productService.save(product)

        then:
        1 * mongoTemplate.save(product)
        0 * _
    }

    def "Test - getName"() {
        given:
        int id = 1
        String name = "TEST"
        Product product = new Product(name: name)

        when:
        String productName = productService.getName(id)

        then:
        1 * mongoTemplate.findById(id, Product.class) >> product
        0 * _

        and:
        productName == name
    }
}