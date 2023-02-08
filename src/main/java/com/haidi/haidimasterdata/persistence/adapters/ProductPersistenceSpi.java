package com.haidi.haidimasterdata.persistence.adapters;

import com.haidi.haidimasterdata.domain.pojo.Product;
import com.haidi.haidimasterdata.domain.ports.out.ProductPersistencePort;
import com.haidi.haidimasterdata.persistence.entities.HaidiFamily;
import com.haidi.haidimasterdata.persistence.entities.ProductsEntity;
import com.haidi.haidimasterdata.persistence.repositories.FamilyRepository;
import com.haidi.haidimasterdata.persistence.repositories.ProductsRepository;
import com.jnape.palatable.lambda.adt.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductPersistenceSpi implements ProductPersistencePort {

    private final ProductsRepository productsRepository;

    private final FamilyRepository familyRepository;

    @Autowired
    public ProductPersistenceSpi(ProductsRepository productsRepository, FamilyRepository familyRepository) {
        this.productsRepository = productsRepository;
        this.familyRepository = familyRepository;
    }

    @Override
    public Long save(Product product) {
        ProductsEntity toSave = new ProductsEntity();
        HaidiFamily familyToLink = familyRepository.findById(product.getFamily()).orElseThrow(
                RuntimeException::new
        );
        setProductToSave(product, toSave, familyToLink);
        return productsRepository.save(toSave).getId();
    }

    @Override
    public void update(Product product) {
        ProductsEntity toSave = new ProductsEntity();
        HaidiFamily familyToLink = familyRepository.findById(product.getFamily()).orElseThrow(
                RuntimeException::new
        );
        toSave.setId(product.getId());
        setProductToSave(product, toSave, familyToLink);
        productsRepository.save(toSave);
    }



    @Override
    public Maybe<Product> findByCode(String code) {
        final var toReturn = productsRepository.findByCode(code);
        if(toReturn != null ){
            Product foundProduct = Product.createOneWithId(
                    toReturn.getId(),
                    toReturn.getCode(),
                    toReturn.getDescription(),
                    toReturn.getQuantity(),
                    toReturn.getUnitOfMeasure(),
                    toReturn.getFamily().getId(),
                    toReturn.getPrice(),
                    toReturn.getSorting());
            return Maybe.maybe(foundProduct);
        }
        return Maybe.nothing();
    }

    @Override
    public Maybe<Product> findById(Long id) {
        final var toReturn = productsRepository.findById(id);
        if(toReturn.isPresent()){
            var found = toReturn.get();
            Product foundProduct = Product.createOneWithId(found.getId(), found.getCode(), found.getDescription(), found.getQuantity(), found.getUnitOfMeasure(), found.getFamily().getId(), found.getPrice(), found.getSorting());
            return Maybe.maybe(foundProduct);
        }
        return Maybe.nothing();
    }

    @Override
    public List<Product> getAllProductsFromDb() {
        return productsRepository
                .findAll()
                .stream()
                .map(item -> Product.createOneWithId(
                        item.getId(),
                        item.getCode(),
                        item.getDescription(),
                        item.getQuantity(),
                        item.getUnitOfMeasure(),
                        item.getFamily() != null ? item.getFamily().getId() : null,
                        item.getPrice(),
                        item.getSorting()))
                .collect(Collectors.toList());
    }

    private void setProductToSave(Product product, ProductsEntity toSave, HaidiFamily familyToLink) {
        toSave.setFamily(familyToLink);
        toSave.setCode(product.getCode());
        toSave.setDescription(product.getDescription());
        toSave.setPrice(product.getPrice());
        toSave.setUnitOfMeasure(product.getUnitOfMeasure());
        toSave.setQuantity(product.getQuantity());
        toSave.setSorting(product.getSorting());
    }
}
