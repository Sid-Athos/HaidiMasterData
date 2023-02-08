package com.haidi.haidimasterdata.persistence.adapters;

import com.haidi.haidimasterdata.domain.pojo.Location;
import com.haidi.haidimasterdata.domain.pojo.Product;
import com.haidi.haidimasterdata.domain.pojo.ProductLocation;
import com.haidi.haidimasterdata.domain.ports.out.ProductLocationPersistencePort;
import com.haidi.haidimasterdata.persistence.entities.Locations;
import com.haidi.haidimasterdata.persistence.entities.ProductLocationsEntity;
import com.haidi.haidimasterdata.persistence.entities.ProductsEntity;
import com.haidi.haidimasterdata.persistence.repositories.LocationRepository;
import com.haidi.haidimasterdata.persistence.repositories.ProductLocationsRepository;
import com.haidi.haidimasterdata.persistence.repositories.ProductsRepository;
import com.jnape.palatable.lambda.adt.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductLocationsPersistenceSpi implements ProductLocationPersistencePort {
    private final ProductLocationsRepository productLocationsRepository;

    private final ProductsRepository productsRepository;
    private final LocationRepository locationRepository;
    @Autowired
    public ProductLocationsPersistenceSpi(ProductLocationsRepository productLocationsRepository, ProductsRepository productsRepository, LocationRepository locationRepository) {
        this.productLocationsRepository = productLocationsRepository;
        this.productsRepository = productsRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Long save(ProductLocation product) {
        ProductLocationsEntity toSave = new ProductLocationsEntity();
        ProductsEntity productsToLink = productsRepository.findById(product.getProduct().getId()).orElseThrow(
                RuntimeException::new
        );
        Locations locationToLink = locationRepository.findById(product.getLocation().getId()).orElseThrow(
                RuntimeException::new
        );
        setProductLocationData(product, toSave, productsToLink, locationToLink);
        return productLocationsRepository.save(toSave).getProductLocationId();
    }

    @Override
    public void update(ProductLocation product) {
        ProductLocationsEntity toSave = new ProductLocationsEntity();
        ProductsEntity productsToLink = productsRepository.findById(product.getProduct().getId()).orElseThrow(
                RuntimeException::new
        );
        Locations locationToLink = locationRepository.findById(product.getLocation().getId()).orElseThrow(
                RuntimeException::new
        );
        toSave.setProductLocationId(product.getProductLocationId());
        setProductLocationData(product, toSave, productsToLink, locationToLink);
        productLocationsRepository.save(toSave);
    }


    @Override
    public Maybe<ProductLocation> findById(Long id) {
        final var toReturn = productLocationsRepository.findById(id);
        if(toReturn.isPresent()){
            var found = toReturn.get();
            ProductLocation foundProductLocation = buildProductLocation(found);
            return Maybe.maybe(foundProductLocation);
        }
        return Maybe.nothing();
    }

    private ProductLocation buildProductLocation(ProductLocationsEntity found){
        Product linkedProduct = found.getProduct() != null ? Product.createOneWithId(
                found.getProduct().getId(),
                found.getProduct().getCode(),
                found.getProduct().getDescription(),
                found.getProduct().getQuantity(),
                found.getProduct().getUnitOfMeasure(),
                found.getProduct().getFamily().getId(),
                found.getProduct().getPrice(),
                found.getProduct().getSorting()
        ): null;
        Location linkedLocation = Location.createLocationWithId(
                found.getLocation().id,
                found.getLocation().code,
                found.getLocation().street,
                found.getLocation().city ,
                found.getLocation().zipCode,
                found.getLocation().country ,
                found.getLocation().description ,
                found.getLocation().locationType.getId() ,
                found.getLocation().channel
        );
        return ProductLocation.createProductLocation(
                found.getProductLocationId(),
                linkedProduct,
                linkedLocation,
                found.getAbc(),
                found.getLotSize(),
                found.getLotSizeUomId(),
                found.getTargetCoverage(),
                found.getMaxCoverage(),
                found.getMinCoverage(),
                found.getRoundingValue(),
                found.getRoundingValueUomId(),
                found.getStartOfLife(),
                found.getEndOfLife(),
                found.getTransformsInto(),
                found.getForecastability()
        );
    }

    @Override
    public List<ProductLocation> getAllLocationsFromDb() {
        return productLocationsRepository
                .findAll()
                .stream()
                .map(this::buildProductLocation
                )
                .collect(Collectors.toList());
    }

    private void setProductLocationData(ProductLocation product, ProductLocationsEntity toSave, ProductsEntity productsToLink, Locations locationToLink) {
        toSave.setProduct(productsToLink);
        toSave.setLocation(locationToLink);
        toSave.setAbc(product.getAbc());
        toSave.setForecastability(product.getForecastability());
        toSave.setLotSize(product.getLotSize());
        toSave.setLotSizeUomId(product.getLotSizeUomId());
        toSave.setStartOfLife(product.getStartOfLife());
        toSave.setEndOfLife(product.getEndOfLife());
        toSave.setTargetCoverage(product.getTargetCoverage());
        toSave.setMinCoverage(product.getMinCoverage());
        toSave.setMaxCoverage(product.getMaxCoverage());
        toSave.setRoundingValue(product.getRoundingValue());
        toSave.setRoundingValueUomId(product.getRoundingValueUomId());
        toSave.setTransformsInto(product.getTransformsInto());
    }
}
