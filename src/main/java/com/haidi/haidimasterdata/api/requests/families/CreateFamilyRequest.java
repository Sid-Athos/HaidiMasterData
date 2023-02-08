package com.haidi.haidimasterdata.api.requests.families;

import java.util.Objects;

public class CreateFamilyRequest {


    public String description;

    public Long parentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateFamilyRequest that = (CreateFamilyRequest) o;
        return description.equals(that.description) && Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, parentId);
    }

    @Override
    public String toString() {
        return "CreateFamilyRequest{" +
                "description='" + description + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
