package com.haidi.haidimasterdata.domain.pojo;

import com.haidi.haidimasterdata.persistence.entities.Locations;

import java.sql.Date;
import java.util.Objects;

public class ProductLocation {
    private Long productLocationId;

    private Product product;

    private Location location;

    private String abc;

    private Double lotSize;

    private Integer lotSizeUomId;

    private Double targetCoverage;

    private Double maxCoverage;

    private Double minCoverage;

    private Integer roundingValue;

    private Integer roundingValueUomId;

    private Date startOfLife;

    private Date endOfLife;

    private Integer transformsInto;

    private Integer forecastability;

    private ProductLocation(Long productLocationId, Product product, Location location, String abc, Double lotSize, Integer lotSizeUomId, Double targetCoverage, Double maxCoverage, Double minCoverage, Integer roundingValue, Integer roundingValueUomId, Date startOfLife, Date endOfLife, Integer transformsInto, Integer forecastability) {
        this.productLocationId = productLocationId;
        this.product = product;
        this.location = location;
        this.abc = abc;
        this.lotSize = lotSize;
        this.lotSizeUomId = lotSizeUomId;
        this.targetCoverage = targetCoverage;
        this.maxCoverage = maxCoverage;
        this.minCoverage = minCoverage;
        this.roundingValue = roundingValue;
        this.roundingValueUomId = roundingValueUomId;
        this.startOfLife = startOfLife;
        this.endOfLife = endOfLife;
        this.transformsInto = transformsInto;
        this.forecastability = forecastability;
    }

    public static ProductLocation createProductLocation(Long productLocationId, Product product, Location location, String abc, Double lotSize, Integer lotSizeUomId, Double targetCoverage, Double maxCoverage, Double minCoverage, Integer roundingValue, Integer roundingValueUomId, Date startOfLife, Date endOfLife, Integer transformsInto, Integer forecastability) {
        return new ProductLocation(productLocationId, product, location, abc, lotSize, lotSizeUomId, targetCoverage, maxCoverage, minCoverage, roundingValue, roundingValueUomId, startOfLife, endOfLife,transformsInto, forecastability);
    }

    private ProductLocation(Product product, Location location, String abc, Double lotSize, Integer lotSizeUomId, Double targetCoverage, Double maxCoverage, Double minCoverage, Integer roundingValue, Integer roundingValueUomId, Date startOfLife, Date endOfLife, Integer transformsInto, Integer forecastability) {
        this.product = product;
        this.location = location;
        this.abc = abc;
        this.lotSize = lotSize;
        this.lotSizeUomId = lotSizeUomId;
        this.targetCoverage = targetCoverage;
        this.maxCoverage = maxCoverage;
        this.minCoverage = minCoverage;
        this.roundingValue = roundingValue;
        this.roundingValueUomId = roundingValueUomId;
        this.startOfLife = startOfLife;
        this.endOfLife = endOfLife;
        this.transformsInto = transformsInto;
        this.forecastability = forecastability;
    }



    public static ProductLocation createProductLocationWithoutId(Product product, Location location, String abc, Double lotSize, Integer lotSizeUomId, Double targetCoverage, Double maxCoverage, Double minCoverage, Integer roundingValue, Integer roundingValueUomId, Date startOfLife, Date endOfLife, Integer transformsInto, Integer forecastability) {
        return new ProductLocation( product, location, abc, lotSize, lotSizeUomId, targetCoverage, maxCoverage, minCoverage, roundingValue, roundingValueUomId, startOfLife, endOfLife,transformsInto, forecastability);
    }


    public Long getProductLocationId() {
        return productLocationId;
    }

    public void setProductLocationId(Long productLocationId) {
        this.productLocationId = productLocationId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    public void setLotSizeUomId(Integer lotSizeUomId) {
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

    public void setRoundingValueUomId(Integer roundingValueUomId) {
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

    public void setTransformsInto(Integer transformsInto) {
        this.transformsInto = transformsInto;
    }

    public Integer getForecastability() {
        return forecastability;
    }

    public void setForecastability(Integer forecastability) {
        this.forecastability = forecastability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLocation that = (ProductLocation) o;
        return lotSizeUomId == that.lotSizeUomId && roundingValueUomId == that.roundingValueUomId && transformsInto == that.transformsInto && forecastability == that.forecastability && Objects.equals(productLocationId, that.productLocationId) && product.equals(that.product) && location.equals(that.location) && Objects.equals(abc, that.abc) && lotSize.equals(that.lotSize) && targetCoverage.equals(that.targetCoverage) && Objects.equals(maxCoverage, that.maxCoverage) && Objects.equals(minCoverage, that.minCoverage) && Objects.equals(roundingValue, that.roundingValue) && Objects.equals(startOfLife, that.startOfLife) && Objects.equals(endOfLife, that.endOfLife);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productLocationId, product, location, abc, lotSize, lotSizeUomId, targetCoverage, maxCoverage, minCoverage, roundingValue, roundingValueUomId, startOfLife, endOfLife, transformsInto, forecastability);
    }

    @Override
    public String toString() {
        return "ProductLocation{" +
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
