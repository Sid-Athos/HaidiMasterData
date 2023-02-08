package com.haidi.haidimasterdata.persistence.entities;

import javax.persistence.*;


import java.util.Objects;

@Entity
@Table(name="product")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_code", nullable = false)
    private String code;

    @Column(name = "product_description", nullable = false)
    private String description;

    @Column(name = "product_quantity", nullable = false)
    private int quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "uom_id")
    private UnitOfMeasure unitOfMeasure;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "family_id")
    private HaidiFamily family;

    @Column(name ="price")
    private Double  price;

    @Column(name ="sorting")
    private String  sorting;


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

    public HaidiFamily getFamily() {
        return family;
    }

    public void setFamily(HaidiFamily family) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity products = (ProductsEntity) o;

        if (quantity != products.quantity) return false;
        if (!id.equals(products.id)) return false;
        if (!code.equals(products.code)) return false;
        if (!description.equals(products.description)) return false;
        if (!unitOfMeasure.equals(products.unitOfMeasure)) return false;
        if (!family.equals(products.family)) return false;
        if (!Objects.equals(price, products.price)) return false;
        return Objects.equals(sorting, products.sorting);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + unitOfMeasure.hashCode();
        result = 31 * result + family.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (sorting != null ? sorting.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unitOfMeasure=" + unitOfMeasure +
                ", family=" + family +
                ", price=" + price +
                ", sorting='" + sorting + '\'' +
                '}';
    }
}
