package com.haidi.haidimasterdata.domain.ports.in;

import com.haidi.haidimasterdata.domain.pojo.ProductLocation;

import java.util.List;

public interface ProductLocationServicePort {

    Long addProductLocation(ProductLocation productLocation);

    void updateProductLocation(ProductLocation productLocation);

    List<ProductLocation> getAllProductLocations();
}
