package com.haidi.haidimasterdata.api.requests.productlocations;

import com.haidi.haidimasterdata.domain.pojo.Location;
import com.haidi.haidimasterdata.domain.pojo.Product;
import com.haidi.haidimasterdata.persistence.entities.Locations;
import com.haidi.haidimasterdata.persistence.entities.ProductsEntity;

import java.sql.Date;
import java.util.Objects;

public class UpdateProductLocationRequest {
    public Long productLocationId;

    public Product product;

    public Location location;

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
        UpdateProductLocationRequest that = (UpdateProductLocationRequest) o;
        return lotSizeUomId == that.lotSizeUomId && roundingValueUomId == that.roundingValueUomId && transformsInto == that.transformsInto && forecastability == that.forecastability && Objects.equals(productLocationId, that.productLocationId) && Objects.equals(product, that.product) && Objects.equals(location, that.location) && Objects.equals(abc, that.abc) && Objects.equals(lotSize, that.lotSize) && Objects.equals(targetCoverage, that.targetCoverage) && Objects.equals(maxCoverage, that.maxCoverage) && Objects.equals(minCoverage, that.minCoverage) && Objects.equals(roundingValue, that.roundingValue) && Objects.equals(startOfLife, that.startOfLife) && Objects.equals(endOfLife, that.endOfLife);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productLocationId, product, location, abc, lotSize, lotSizeUomId, targetCoverage, maxCoverage, minCoverage, roundingValue, roundingValueUomId, startOfLife, endOfLife, transformsInto, forecastability);
    }

    @Override
    public String toString() {
        return "UpdateProductLocationRequest{" +
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
