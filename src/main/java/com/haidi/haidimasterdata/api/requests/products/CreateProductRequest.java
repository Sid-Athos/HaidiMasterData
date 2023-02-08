package com.haidi.haidimasterdata.api.requests.products;

import com.haidi.haidimasterdata.persistence.entities.UnitOfMeasure;

import java.util.Objects;

public class CreateProductRequest {

    public String code;

    public String description;

    public int quantity;

    public UnitOfMeasure unitOfMeasure;

    public Long family;

    public Double  price;

    public String  sorting;

    public CreateProductRequest(String code, String description, int quantity, UnitOfMeasure unitOfMeasure, Long family, Double price, String sorting) {
        this.code = code;
        this.description = description;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.family = family;
        this.price = price;
        this.sorting = sorting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateProductRequest that = (CreateProductRequest) o;

        if (quantity != that.quantity) return false;
        if (!code.equals(that.code)) return false;
        if (!description.equals(that.description)) return false;
        if (!unitOfMeasure.equals(that.unitOfMeasure)) return false;
        if (!family.equals(that.family)) return false;
        if (!price.equals(that.price)) return false;
        return Objects.equals(sorting, that.sorting);
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + unitOfMeasure.hashCode();
        result = 31 * result + family.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + sorting.hashCode();
        return result;
    }
}
