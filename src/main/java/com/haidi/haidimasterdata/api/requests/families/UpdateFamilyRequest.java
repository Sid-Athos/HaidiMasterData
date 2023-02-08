package com.haidi.haidimasterdata.api.requests.families;

import java.util.Objects;

public class UpdateFamilyRequest {

    public Long id;

    public String description;

    public Long parentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateFamilyRequest that = (UpdateFamilyRequest) o;
        return id.equals(that.id) && description.equals(that.description) && Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, parentId);
    }

    @Override
    public String toString() {
        return "UpdateFamilyRequest{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
