package org.webservice.assign05c0122500698.service;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Service;
import org.webservice.assign05c0122500698.domain.Product;
import org.webservice.assign05c0122500698.dto.ProductRequest;
import org.webservice.assign05c0122500698.dto.ProductResponse;
import org.webservice.assign05c0122500698.repository.MemoryProductRepository;

@Service
public class ProductService {
    MemoryProductRepository pr = new MemoryProductRepository();

    public Product create(ProductRequest request) {
        return pr.save(new Product(null, request.name(), request.description(), request.category(), request.date(), request.price()));
    }

    private ProductResponse toResponse(Product p) {
        return new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getCategory(), p.getDate(), p.getPrice());
    }
}
