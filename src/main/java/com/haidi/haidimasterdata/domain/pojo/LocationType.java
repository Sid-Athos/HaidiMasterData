package com.haidi.haidimasterdata.domain.pojo;

import javax.persistence.Id;
import java.util.Objects;

public class LocationType {

    private Long id;

    private String description;

    public LocationType(String description) {
        this.description = description;
    }

    private LocationType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public static LocationType createLocationTypeToUpdate(Long id, String description){
        return new LocationType(id, description);
    }

    public static LocationType createLocationType( String description){
        return new LocationType( description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationType that = (LocationType) o;
        return id.equals(that.id) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "LocationType{" +
                "id=" + id +
                ", description=" + description +
                '}';
    }
}
