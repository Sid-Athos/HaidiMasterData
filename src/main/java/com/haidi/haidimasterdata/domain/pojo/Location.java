package com.haidi.haidimasterdata.domain.pojo;


import java.util.Objects;

public class Location {

    private Long id;

    private String code ;

    private String street;

    private String city;

    private String zipCode;

    private String country;

    private String description;

    private Long locationType;

    private Long channel;

    public Location(Long id) {
        this.id = id;
    }

    private Location(Long id, String code, String street, String city, String zipCode, String country, String description, Long locationType, Long channel) {
        this.id = id;
        this.code = code;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.description = description;
        this.locationType = locationType;
        this.channel = channel;
    }

    private Location(String code, String street, String city, String zipCode, String country, String description, Long locationType, Long channel) {
        this.code = code;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.description = description;
        this.locationType = locationType;
        this.channel = channel;
    }

    public static Location createLocation(String code, String street, String city, String zipCode, String country, String description, Long locationType, Long channel) {
        return new Location( code, street, city, zipCode, country, description, locationType, channel);
    }

    public static Location createLocationWithId(Long id, String code, String street, String city, String zipCode, String country, String description, Long locationType, Long channel) {
        return new Location(id, code, street, city, zipCode, country, description, locationType, channel);
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLocationType() {
        return locationType;
    }

    public void setLocationType(Long locationType) {
        this.locationType = locationType;
    }

    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) && code.equals(location.code) && Objects.equals(street, location.street) && Objects.equals(city, location.city) && Objects.equals(zipCode, location.zipCode) && country.equals(location.country) && description.equals(location.description) && Objects.equals(locationType, location.locationType) && channel.equals(location.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, street, city, zipCode, country, description, locationType, channel);
    }

    @Override
    public String toString() {
        return "Location{" +
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
