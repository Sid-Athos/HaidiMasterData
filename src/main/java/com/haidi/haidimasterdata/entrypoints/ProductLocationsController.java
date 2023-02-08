package com.haidi.haidimasterdata.entrypoints;

import com.haidi.haidimasterdata.api.requests.productlocations.CreateProductLocationRequest;
import com.haidi.haidimasterdata.api.requests.productlocations.UpdateProductLocationRequest;
import com.haidi.haidimasterdata.api.requests.products.CreateProductRequest;
import com.haidi.haidimasterdata.api.requests.products.UpdateProductRequest;
import com.haidi.haidimasterdata.domain.pojo.Location;
import com.haidi.haidimasterdata.domain.pojo.Product;
import com.haidi.haidimasterdata.domain.pojo.ProductLocation;
import com.haidi.haidimasterdata.domain.ports.in.ProductLocationServicePort;
import com.haidi.haidimasterdata.domain.ports.in.ProductServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productLocations")
public class ProductLocationsController {

    private final ProductLocationServicePort productLocationServicePort;

    @Autowired
    public ProductLocationsController(ProductLocationServicePort productLocationServicePort) {
        this.productLocationServicePort = productLocationServicePort;
    }

    @PostMapping(value = "/createProductLocation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long createProduct(@RequestBody CreateProductLocationRequest productLocationRequest){
        Product product = new Product(productLocationRequest.product);
        Location location = new Location(productLocationRequest.location);
        final var productLocation = ProductLocation.createProductLocationWithoutId(
                product,
                location,
                productLocationRequest.abc,
                productLocationRequest.lotSize,
                productLocationRequest.lotSizeUomId,
                productLocationRequest.targetCoverage,
                productLocationRequest.maxCoverage,
                productLocationRequest.minCoverage,
                productLocationRequest.roundingValue,
                productLocationRequest.roundingValueUomId,
                productLocationRequest.startOfLife,
                productLocationRequest.endOfLife,
                productLocationRequest.transformsInto,
                productLocationRequest.forecastability);
        return productLocationServicePort.addProductLocation(productLocation);
    }

    @PutMapping(value = "/updateProductLocation", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody UpdateProductLocationRequest productLocationRequest){
        Product product = new Product(productLocationRequest.product.getId());
        Location location = new Location(productLocationRequest.location.getId());
        final var productLocation = ProductLocation.createProductLocation(
                productLocationRequest.productLocationId,
                product,
                location,
                productLocationRequest.abc,
                productLocationRequest.lotSize,
                productLocationRequest.lotSizeUomId,
                productLocationRequest.targetCoverage,
                productLocationRequest.maxCoverage,
                productLocationRequest.minCoverage,
                productLocationRequest.roundingValue,
                productLocationRequest.roundingValueUomId,
                productLocationRequest.startOfLife,
                productLocationRequest.endOfLife,
                productLocationRequest.transformsInto,
                productLocationRequest.forecastability);
        productLocationServicePort.updateProductLocation(productLocation);
    }

    @GetMapping(value = "/findAllProductLocations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductLocation> findAllProducts(){
        return productLocationServicePort.getAllProductLocations();
    }
}
