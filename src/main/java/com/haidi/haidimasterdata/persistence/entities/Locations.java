package com.haidi.haidimasterdata.persistence.entities;



import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="location")
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "location_id")
    public Long id;

    @Column(name="location_code", nullable = false)
    public String code ;

    @Column(name = "street")
    public String street;


    @Column(name = "city")
    public String city;

    @Column(name = "zip")
    public String zipCode;
    @Column(name = "country")
    public String country;

    @Column(name = "location_description", nullable = false)
    public String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_type_id")
    public LocationType locationType;

    @Column(name = "channel_id", nullable = false)
    public Long channel;

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

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
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

        Locations locations = (Locations) o;

        if (!Objects.equals(id, locations.id)) return false;
        if (!Objects.equals(code, locations.code)) return false;
        if (!Objects.equals(street, locations.street)) return false;
        if (!Objects.equals(city, locations.city)) return false;
        if (!Objects.equals(zipCode, locations.zipCode)) return false;
        if (!Objects.equals(country, locations.country)) return false;
        if (!Objects.equals(description, locations.description))
            return false;
        if (!Objects.equals(locationType, locations.locationType))
            return false;
        return Objects.equals(channel, locations.channel);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (locationType != null ? locationType.hashCode() : 0);
        result = 31 * result + (channel != null ? channel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Locations{" +
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
