package com.haidi.haidimasterdata.domain.pojo;

import com.haidi.haidimasterdata.persistence.entities.UnitOfMeasure;

public class Product {

    private Long id;

    private String code;

    private String description;

    private int quantity;

    private UnitOfMeasure unitOfMeasure;

    private Long family;

    private Double  price;

    private String  sorting;

    public Product(Long id) {
        this.id = id;
    }

    private Product(String code, String description, int quantity, UnitOfMeasure unitOfMeasure, Long family, Double price, String sorting) {
        this.code = code;
        this.description = description;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.family = family;
        this.price = price;
        this.sorting = sorting;
    }

    public Product(Long id, String code, String description, int quantity, UnitOfMeasure unitOfMeasure, Long family, Double price, String sorting) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.family = family;
        this.price = price;
        this.sorting = sorting;
    }

    public static Product createOne(String code, String description, int quantity, UnitOfMeasure unitOfMeasure, Long family, Double price, String sorting){
        return new Product(code, description, quantity, unitOfMeasure, family, price, sorting);
    }

    public static Product createOneWithId(Long id ,String code, String description, int quantity, UnitOfMeasure unitOfMeasure, Long family, Double price, String sorting){
        return new Product(id, code, description, quantity, unitOfMeasure, family, price, sorting);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Long getFamily() {
        return family;
    }

    public void setFamily(Long family) {
        this.family = family;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
        this.sorting = sorting;
    }
}
