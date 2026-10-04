package org.webservice.assign05c0122500698.repository;

import org.springframework.stereotype.Repository;
import org.webservice.assign05c0122500698.domain.Product;

import java.util.*;

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
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(list.get(id));
    }


    @Override
    public List<Product> findAll() {
        List<Product> plist = new ArrayList<>(list.values());
        return plist;
    }

    @Override
    public Product update(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
