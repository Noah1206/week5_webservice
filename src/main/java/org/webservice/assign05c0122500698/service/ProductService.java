package org.webservice.assign05c0122500698.service;

import org.apache.catalina.connector.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return pr.save(checkRequest(request));
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
        findProduct(id);
        return toResponse(pr.update(id, checkRequest(request)));
    }

    public void delete(long id) {
        findProduct(id);
        pr.delete(id);
    }
//    등록 또는 수정 시 잘못된 값이 저장되지 않도록 처리합니다.
//
//            예: 필수 문자열이 비어 있음, 가격이 음수임, 평점이 허용 범위를 벗어남
//
//    잘못된 요청에는 400 Bad Request 반환
//    정상 데이터는 등록 또는 수정 가능

    public Product checkRequest(ProductRequest request) {
        boolean isVaild = true;

        if(request.name().isEmpty() || request.description().isEmpty() || request.category().isEmpty()) {
            isVaild=false;
        }
        if(request.price() < 0) {
            isVaild=false;
        }
        if(request.date() < 1900 || request.date() > 2026) {
            isVaild=false;
        }

        if(!isVaild) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 요청 형식입니다.");
        }
        return new Product(null, request.name(), request.description(), request.category(), request.date(), request.price());
    }

    public List<ProductResponse> findCategory(String category) {

    }
}
