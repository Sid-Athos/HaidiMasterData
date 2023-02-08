package com.haidi.haidimasterdata.api.requests.locations;

import java.util.Objects;

public class UpdateLocationRequest {

    public Long id;

    public String code ;

    public String street;

    public String city;

    public String zipCode;

    public String country;

    public String description;

    public Long locationType;

    public Long channel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateLocationRequest that = (UpdateLocationRequest) o;
        return id.equals(that.id) && code.equals(that.code) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(zipCode, that.zipCode) && Objects.equals(country, that.country) && description.equals(that.description) && Objects.equals(locationType, that.locationType) && Objects.equals(channel, that.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, street, city, zipCode, country, description, locationType, channel);
    }

    @Override
    public String toString() {
        return "UpdateLocationRequest{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", locationType=" + locationType +
                ", channel=" + channel +
                '}';
    }
}
