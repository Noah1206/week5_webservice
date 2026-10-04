package org.webservice.assign05c0122500698.service;

import org.apache.catalina.connector.Request;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.webservice.assign05c0122500698.domain.Product;
import org.webservice.assign05c0122500698.dto.ProductRequest;
import org.webservice.assign05c0122500698.dto.ProductResponse;
import org.webservice.assign05c0122500698.repository.MemoryProductRepository;

import java.util.List;

@Service
public class ProductService {
    MemoryProductRepository pr = new MemoryProductRepository();

    public Product create(ProductRequest request) {
        return pr.save(new Product(null, request.name(), request.description(), request.category(), request.date(), request.price()));
    }

    private ProductResponse toResponse(Product p) {
        return new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getCategory(), p.getDate(), p.getPrice());
    }

    public ProductResponse findById(long id) {
        return toResponse(findProduct(id));
    }

    public Product findProduct(long id) {
        return pr.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product is not found " + id));
    }

    public List<ProductResponse> findAll() {
        return pr.findAll().stream().map(this::toResponse).toList();
    }

    public ProductResponse update(long id, ProductRequest request) {
        return toResponse(pr.update(id, new Product(null, request.name(), request.description(), request.category(), request.date(), request.price())));
    }
}
