package com.haidi.haidimasterdata.api.requests.products;

import com.haidi.haidimasterdata.persistence.entities.UnitOfMeasure;

public class UpdateProductRequest {

    public Long id;

    public String code;

    public String description;

    public Integer quantity;

    public UnitOfMeasure unitOfMeasure;

    public Long family;

    public Double  price;

    public String  sorting;

    public UpdateProductRequest(Long id, String code, String description, int quantity, UnitOfMeasure unitOfMeasure, Long family, Double price, String sorting) {
        this.id = id;
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

        UpdateProductRequest that = (UpdateProductRequest) o;

        if (quantity != that.quantity) return false;
        if (!id.equals(that.id)) return false;
        if (!code.equals(that.code)) return false;
        if (!description.equals(that.description)) return false;
        if (!unitOfMeasure.equals(that.unitOfMeasure)) return false;
        if (!family.equals(that.family)) return false;
        if (!price.equals(that.price)) return false;
        return sorting.equals(that.sorting);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + unitOfMeasure.hashCode();
        result = 31 * result + family.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + sorting.hashCode();
        return result;
    }
}
