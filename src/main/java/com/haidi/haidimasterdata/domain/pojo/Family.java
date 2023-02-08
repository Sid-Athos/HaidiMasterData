package com.haidi.haidimasterdata.domain.pojo;

import java.util.Objects;

public class Family {

    private Long id;

    private String description;

    private Long parentId;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    private Family(Long id, String description, Long parentId) {
        this.id = id;
        this.description = description;
        this.parentId = parentId;
    }

    public Family(String description, Long parentId) {
        this.description = description;
        this.parentId = parentId;
    }

    public static Family createFamily(String description, Long parentId) {
        return new Family( description, parentId);
    }



    public static Family createFamilyToUpdate(Long id, String description, Long parentId) {
        return new Family( id, description, parentId);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(id, family.id) && Objects.equals(description, family.description) && Objects.equals(parentId, family.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, parentId);
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
