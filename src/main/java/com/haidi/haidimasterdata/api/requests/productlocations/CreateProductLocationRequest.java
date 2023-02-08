package com.haidi.haidimasterdata.api.requests.productlocations;


import java.sql.Date;
import java.util.Objects;

public class CreateProductLocationRequest {

    public Long product;

    public Long location;

    public String abc;

    public Double lotSize;

    public int lotSizeUomId;

    public Double targetCoverage;

    public Double maxCoverage;

    
    
    public Double minCoverage;

    public Integer roundingValue;


    public int roundingValueUomId;

    public Date startOfLife;

    public Date endOfLife;

    public int transformsInto;

    public int forecastability;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProductLocationRequest that = (CreateProductLocationRequest) o;
        return lotSizeUomId == that.lotSizeUomId && roundingValueUomId == that.roundingValueUomId && transformsInto == that.transformsInto && forecastability == that.forecastability && product.equals(that.product) && location.equals(that.location) && Objects.equals(abc, that.abc) && Objects.equals(lotSize, that.lotSize) && Objects.equals(targetCoverage, that.targetCoverage) && Objects.equals(maxCoverage, that.maxCoverage) && Objects.equals(minCoverage, that.minCoverage) && Objects.equals(roundingValue, that.roundingValue) && Objects.equals(startOfLife, that.startOfLife) && Objects.equals(endOfLife, that.endOfLife);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, location, abc, lotSize, lotSizeUomId, targetCoverage, maxCoverage, minCoverage, roundingValue, roundingValueUomId, startOfLife, endOfLife, transformsInto, forecastability);
    }

    @Override
    public String toString() {
        return "CreateProductLocationRequest{" +
                "product=" + product +
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
