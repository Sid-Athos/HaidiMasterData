package com.haidi.haidimasterdata.entrypoints;

import com.haidi.haidimasterdata.api.requests.products.CreateProductRequest;
import com.haidi.haidimasterdata.api.requests.products.UpdateProductRequest;
import com.haidi.haidimasterdata.domain.pojo.Product;
import com.haidi.haidimasterdata.domain.ports.in.ProductServicePort;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductServicePort productsServicePort;

    @Autowired
    public ProductsController(ProductServicePort productsServicePort) {
        this.productsServicePort = productsServicePort;
    }

    @ApiResponse(responseCode = "200", description = "Created product database Identifier")
    @PostMapping(value = "/createProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long createProduct(@RequestBody CreateProductRequest productRequest){
        final var product = Product.createOne(
                productRequest.code,
                productRequest.description,
                productRequest.quantity,
                productRequest.unitOfMeasure,
                productRequest.family,
                productRequest.price,
                productRequest.sorting);
       return productsServicePort.addProduct(product);
    }

    @PutMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(responseCode = "204", description = "Successfully updated product")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody UpdateProductRequest productRequest){
        final var product = Product.createOneWithId(
                productRequest.id,
                productRequest.code,
                productRequest.description,
                productRequest.quantity,
                productRequest.unitOfMeasure,
                productRequest.family,
                productRequest.price,
                productRequest.sorting);
        productsServicePort.updateProduct(product);
    }

    @ApiResponse(responseCode = "200", description = "Successfully retrieved all products")
    @GetMapping(value = "/findProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAllProducts(){
        return productsServicePort.getAllProducts();
    }
}
