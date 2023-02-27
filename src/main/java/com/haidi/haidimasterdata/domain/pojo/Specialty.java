package com.haidi.haidimasterdata.domain.pojo;


import java.util.Objects;

public class Specialty {

    private Long id;

    private String specialtyDescription;

    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialtyDescription() {
        return specialtyDescription;
    }

    public void setSpecialtyDescription(String specialtyDescription) {
        this.specialtyDescription = specialtyDescription;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return Objects.equals(id, specialty.id) && specialtyDescription.equals(specialty.specialtyDescription) && Objects.equals(comment, specialty.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialtyDescription, comment);
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", specialtyDescription='" + specialtyDescription + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
