package com.haidi.haidimasterdata.domain.services;

import com.haidi.haidimasterdata.domain.pojo.ProductLocation;
import com.haidi.haidimasterdata.domain.ports.in.ProductLocationServicePort;
import com.haidi.haidimasterdata.domain.ports.out.ProductLocationPersistencePort;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductLocationOperationService implements ProductLocationServicePort {

    private static final Logger LOGGER = Logger.getLogger(ProductLocationOperationService.class.getName());


    private final ProductLocationPersistencePort productLocationPersistencePort;
    public ProductLocationOperationService(ProductLocationPersistencePort productLocationPersistencePort) {
        this.productLocationPersistencePort = productLocationPersistencePort;
    }

    @Override
    public Long addProductLocation(ProductLocation productLocation) {
        LOGGER.log(Level.INFO, "Saving new product location "  + productLocation);
        var maybeProductLocation = productLocationPersistencePort.findById(productLocation.getProductLocationId());
        var savedProductLocation = maybeProductLocation.orElseGet(() -> {
            if(productLocation.getLocation() == null || productLocation.getLocation().getId() == null){
                LOGGER.log(Level.SEVERE, "Illegal operation, Null location for product location not supported.");
                throw new RuntimeException("Invalid location (null)");
            }
            if(productLocation.getProduct() == null || productLocation.getProduct().getId() == null){
                LOGGER.log(Level.SEVERE, "Illegal operation, Null product for product location not supported.");
                throw new RuntimeException("Invalid Product (null)");
            }
            final var itemId =  productLocationPersistencePort.save(productLocation);
            productLocation.setProductLocationId(itemId);
            return productLocation;
        });
        LOGGER.log(Level.INFO, "Product location saved with ID  "  + savedProductLocation.getProductLocationId());
        return savedProductLocation.getProductLocationId();
    }

    @Override
    public void updateProductLocation(ProductLocation productLocation) {
        LOGGER.log(Level.INFO, "Updating product location "  + productLocation);
        productLocationPersistencePort.findById(productLocation.getProductLocationId())
                .fmap(productLocationFromDb -> {
                    LOGGER.log(Level.INFO, "Product location in db found "  + productLocationFromDb);
                    productLocationPersistencePort.update(productLocation);
                    return productLocation;
                }).orElseThrow(() -> {
                    throw new RuntimeException();
                });
        LOGGER.log(Level.INFO, "Product location updated ");
    }

    @Override
    public List<ProductLocation> getAllProductLocations() {
        LOGGER.log(Level.INFO, "Fetching all product locations");
        return productLocationPersistencePort.getAllLocationsFromDb();
    }
}
