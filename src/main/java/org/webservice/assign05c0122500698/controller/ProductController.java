package org.webservice.assign05c0122500698.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webservice.assign05c0122500698.domain.Product;
import org.webservice.assign05c0122500698.dto.ProductRequest;
import org.webservice.assign05c0122500698.dto.ProductResponse;
import org.webservice.assign05c0122500698.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService ps;

    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.create(request));
    }

    // Read findById, findAll
    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable long id) {
        return ps.findById(id);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return ps.findAll();
    }

    // Update
    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable long id, @RequestBody ProductRequest request) {
        return ps.update(id, request);
    }
}
