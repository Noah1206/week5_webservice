package org.webservice.assign05c0122500698.repository;

import org.springframework.stereotype.Repository;
import org.webservice.assign05c0122500698.domain.Product;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryProductRepository implements ProductRepository{
    Map<Long, Product> list = new LinkedHashMap<>();
    long sequence = 0;
    @Override
    public Product save(Product p) {
        p.setId(++sequence);
        list.put(p.getId(), p);
        return p;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product update(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
