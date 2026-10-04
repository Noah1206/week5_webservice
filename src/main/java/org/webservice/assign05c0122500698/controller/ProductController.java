package org.webservice.assign05c0122500698.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.assign05c0122500698.domain.Product;
import org.webservice.assign05c0122500698.dto.ProductRequest;
import org.webservice.assign05c0122500698.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService ps;

    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.create(request));
    }

    // Read findById, findAll


    // 
}
