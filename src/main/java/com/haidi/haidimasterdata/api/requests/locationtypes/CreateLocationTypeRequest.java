package com.haidi.haidimasterdata.api.requests.locationtypes;

import java.util.Objects;

public class CreateLocationTypeRequest {

    public String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateLocationTypeRequest that = (CreateLocationTypeRequest) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "CreateLocationTypeRequest{" +
                "description=" + description +
                '}';
    }
}
