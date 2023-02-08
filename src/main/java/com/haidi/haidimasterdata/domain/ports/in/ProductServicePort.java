package com.haidi.haidimasterdata.domain.ports.in;

import com.haidi.haidimasterdata.domain.pojo.Product;

import java.util.List;

public interface ProductServicePort {
    Long addProduct(Product product);

    void updateProduct(Product product);

    List<Product> getAllProducts();

}
