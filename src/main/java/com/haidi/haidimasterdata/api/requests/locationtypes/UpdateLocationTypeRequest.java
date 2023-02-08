package com.haidi.haidimasterdata.api.requests.locationtypes;

import java.util.Objects;

public class UpdateLocationTypeRequest {

    public Long id;

    public String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateLocationTypeRequest that = (UpdateLocationTypeRequest) o;
        return id.equals(that.id) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "UpdateLocationTypeRequest{" +
                "id=" + id +
                ", description=" + description +
                '}';
    }
}
