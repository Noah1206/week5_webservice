package org.webservice.assign05c0122500698.repository;

import org.webservice.assign05c0122500698.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    public Product save(Product p);
    public Optional<Product> findById(Long id);
    public List<Product> findAll();
    public Product update(Long id, Product p);
    public void delete(Long id);
}
