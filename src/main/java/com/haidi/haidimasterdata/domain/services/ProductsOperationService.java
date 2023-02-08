package com.haidi.haidimasterdata.domain.services;

import com.haidi.haidimasterdata.domain.pojo.Product;
import com.haidi.haidimasterdata.domain.ports.in.ProductServicePort;
import com.haidi.haidimasterdata.domain.ports.out.ProductPersistencePort;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductsOperationService implements ProductServicePort {

    private static final Logger LOGGER = Logger.getLogger(ProductsOperationService.class.getName());

    private final ProductPersistencePort productPersistencePort;

    public ProductsOperationService(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }


    @Override
    public Long addProduct(Product product) {
        LOGGER.log(Level.INFO, "Saving new product "  + product);
        var maybeProduct = productPersistencePort.findByCode(product.getCode());
        var result = maybeProduct.orElseGet(() -> {
            if(product.getFamily() == null){
                LOGGER.log(Level.SEVERE, "Illegal operation, Null family not supported.");
                throw new RuntimeException("Invalid Family (null)");
            }
            final var itemId =  productPersistencePort.save(product);
            product.setId(itemId);
            return product;
        });
        LOGGER.log(Level.INFO, "Product saved with ID  "  + product.getId());
        return result.getId();
    }

    @Override
    public void updateProduct(Product product) {
        LOGGER.log(Level.INFO, "Updating product "  + product);
         productPersistencePort.findById(product.getId())
                .fmap(productFromDb -> {
                    LOGGER.log(Level.INFO, "Product in db found "  + productFromDb);
                    productPersistencePort.update(product);
                    return productFromDb;
                }).orElseThrow(() -> {
                    throw new RuntimeException();
                });
        LOGGER.log(Level.INFO, "Product updated ");

    }

    @Override
    public List<Product> getAllProducts() {
        LOGGER.log(Level.INFO, "Retrieving all products for company");
        return productPersistencePort.getAllProductsFromDb();
    }

}
