package com.haidi.haidimasterdata.api.requests;


import java.util.Objects;

public class SpecialtyRequest {

    public Long id;

    public String specialtyDescription;

    public String comment;


    public SpecialtyRequest(Long id, String specialtyDescription, String comment) {
        this.id = id;
        this.specialtyDescription = specialtyDescription;
        this.comment = comment;
    }


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
        SpecialtyRequest specialtyRequest = (SpecialtyRequest) o;
        return Objects.equals(id, specialtyRequest.id) && specialtyDescription.equals(specialtyRequest.specialtyDescription) && Objects.equals(comment, specialtyRequest.comment);
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
