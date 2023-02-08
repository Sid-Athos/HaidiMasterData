package com.haidi.haidimasterdata.domain.pojo;

import java.util.Objects;

public class UnitOfMeasure {
    private Long id;

    private String code;

    private String description;

    private UnitOfMeasure(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public static UnitOfMeasure createUnitOfMeasure(Long id, String code, String description){
        return new UnitOfMeasure(id, code, description);
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
        UnitOfMeasure that = (UnitOfMeasure) o;
        return id.equals(that.id) && code.equals(that.code) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, description);
    }

    @Override
    public String toString() {
        return "UniOtMeasure{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
