package com.myretail.myretailservice.controller

import com.myretail.myretailservice.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class ProductNameControllerSpec extends Specification {

    ProductService productService = Mock()
    ProductNameController productNameController = new ProductNameController(productService)

    def "Test - getName"() {
        given:
        int id = 1
        String name = "TEST"
        when:
        ResponseEntity<String> responseEntity = productNameController.getName(id, null)

        then:
        1 * productService.getName(id) >> name
        0 * _

        and:
        responseEntity.statusCode == HttpStatus.OK
        responseEntity.getBody() == name


    }
}