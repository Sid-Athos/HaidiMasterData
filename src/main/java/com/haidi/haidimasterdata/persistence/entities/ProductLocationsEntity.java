package com.haidi.haidimasterdata.persistence.entities;

import com.haidi.haidimasterdata.domain.pojo.Product;
import javax.persistence.*;


import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="product_location")
public class ProductLocationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_location_id")
    private Long productLocationId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private ProductsEntity product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    private Locations location;

    @Column(name = "abc")
    private String abc;

    @Column(name = "lot_size")
    private Double lotSize;

    @Column(name = "lot_size_uom_id")
    private Integer lotSizeUomId;

    @Column(name = "target_coverage")
    private Double targetCoverage;

    @Column(name = "max_coverage")
    private Double maxCoverage;

    @Column(name = "min_coverage")
    private Double minCoverage;

    @Column(name = "rounding_value")
    private Integer roundingValue;

    @Column(name = "rounding_value_uom_id")
    private Integer roundingValueUomId;

    @Column(name = "start_of_life")
    private Date startOfLife;

    @Column(name = "end_of_life")
    private Date endOfLife;

    @Column(name = "transform_into")
    private Integer transformsInto;

    @Column(name = "forecastability")
    private Integer forecastability;

    public Long getProductLocationId() {
        return productLocationId;
    }

    public void setProductLocationId(Long productLocationId) {
        this.productLocationId = productLocationId;
    }

    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public Double getLotSize() {
        return lotSize;
    }

    public void setLotSize(Double lotSize) {
        this.lotSize = lotSize;
    }

    public Integer getLotSizeUomId() {
        return lotSizeUomId;
    }

    public void setLotSizeUomId(int lotSizeUomId) {
        this.lotSizeUomId = lotSizeUomId;
    }

    public Double getTargetCoverage() {
        return targetCoverage;
    }

    public void setTargetCoverage(Double targetCoverage) {
        this.targetCoverage = targetCoverage;
    }

    public Double getMaxCoverage() {
        return maxCoverage;
    }

    public void setMaxCoverage(Double maxCoverage) {
        this.maxCoverage = maxCoverage;
    }

    public Double getMinCoverage() {
        return minCoverage;
    }

    public void setMinCoverage(Double minCoverage) {
        this.minCoverage = minCoverage;
    }

    public Integer getRoundingValue() {
        return roundingValue;
    }

    public void setRoundingValue(Integer roundingValue) {
        this.roundingValue = roundingValue;
    }

    public Integer getRoundingValueUomId() {
        return roundingValueUomId;
    }

    public void setRoundingValueUomId(int roundingValueUomId) {
        this.roundingValueUomId = roundingValueUomId;
    }

    public Date getStartOfLife() {
        return startOfLife;
    }

    public void setStartOfLife(Date startOfLife) {
        this.startOfLife = startOfLife;
    }

    public Date getEndOfLife() {
        return endOfLife;
    }

    public void setEndOfLife(Date endOfLife) {
        this.endOfLife = endOfLife;
    }

    public Integer getTransformsInto() {
        return transformsInto;
    }

    public void setTransformsInto(int transformsInto) {
        this.transformsInto = transformsInto;
    }

    public Integer getForecastability() {
        return forecastability;
    }

    public void setForecastability(int forecastability) {
        this.forecastability = forecastability;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductLocationsEntity that = (ProductLocationsEntity) o;

        if (lotSizeUomId != that.lotSizeUomId) return false;
        if (roundingValueUomId != that.roundingValueUomId) return false;
        if (transformsInto != that.transformsInto) return false;
        if (forecastability != that.forecastability) return false;
        if (!Objects.equals(productLocationId, that.productLocationId))
            return false;
        if (!Objects.equals(product, that.product)) return false;
        if (!Objects.equals(location, that.location)) return false;
        if (!Objects.equals(abc, that.abc)) return false;
        if (!Objects.equals(lotSize, that.lotSize)) return false;
        if (!Objects.equals(targetCoverage, that.targetCoverage))
            return false;
        if (!Objects.equals(maxCoverage, that.maxCoverage)) return false;
        if (!Objects.equals(minCoverage, that.minCoverage)) return false;
        if (!Objects.equals(roundingValue, that.roundingValue))
            return false;
        if (!Objects.equals(startOfLife, that.startOfLife)) return false;
        return Objects.equals(endOfLife, that.endOfLife);
    }

    @Override
    public int hashCode() {
        int result = productLocationId != null ? productLocationId.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (abc != null ? abc.hashCode() : 0);
        result = 31 * result + (lotSize != null ? lotSize.hashCode() : 0);
        result = 31 * result + lotSizeUomId;
        result = 31 * result + (targetCoverage != null ? targetCoverage.hashCode() : 0);
        result = 31 * result + (maxCoverage != null ? maxCoverage.hashCode() : 0);
        result = 31 * result + (minCoverage != null ? minCoverage.hashCode() : 0);
        result = 31 * result + (roundingValue != null ? roundingValue.hashCode() : 0);
        result = 31 * result + roundingValueUomId;
        result = 31 * result + (startOfLife != null ? startOfLife.hashCode() : 0);
        result = 31 * result + (endOfLife != null ? endOfLife.hashCode() : 0);
        result = 31 * result + transformsInto;
        result = 31 * result + forecastability;
        return result;
    }

    @Override
    public String toString() {
        return "ProductLocationsEntity{" +
                "productLocationId=" + productLocationId +
                ", product=" + product +
                ", location=" + location +
                ", abc='" + abc + '\'' +
                ", lotSize=" + lotSize +
                ", lotSizeUomId=" + lotSizeUomId +
                ", targetCoverage=" + targetCoverage +
                ", maxCoverage=" + maxCoverage +
                ", minCoverage=" + minCoverage +
                ", roundingValue=" + roundingValue +
                ", roundingValueUomId=" + roundingValueUomId +
                ", startOfLife=" + startOfLife +
                ", endOfLife=" + endOfLife +
                ", transformsInto=" + transformsInto +
                ", forecastability=" + forecastability +
                '}';
    }
}
