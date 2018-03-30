package com.myretail.myretailservice.controller;

import com.myretail.myretailservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/pdp/tcin")
public class ProductNameController {

    public ProductNameController(ProductService productService) {
        this.productService = productService;
    }

    private final ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    ResponseEntity<String> getName(@PathVariable(value = "id") int id, @RequestParam(value = "excludes", required = false) String param) {
        return new ResponseEntity<>(productService.getName(id), HttpStatus.OK);
    }
}