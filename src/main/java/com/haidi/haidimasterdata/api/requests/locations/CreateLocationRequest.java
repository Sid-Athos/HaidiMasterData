package com.haidi.haidimasterdata.api.requests.locations;

import java.util.Objects;

public class CreateLocationRequest {

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
        CreateLocationRequest that = (CreateLocationRequest) o;
        return code.equals(that.code) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(zipCode, that.zipCode) && country.equals(that.country) && description.equals(that.description) && locationType.equals(that.locationType) && Objects.equals(channel, that.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, street, city, zipCode, country, description, locationType, channel);
    }

    @Override
    public String toString() {
        return "CreateLocationRequest{" +
                "code='" + code + '\'' +
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
