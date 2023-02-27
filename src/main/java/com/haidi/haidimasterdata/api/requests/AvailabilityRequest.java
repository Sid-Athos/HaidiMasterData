package com.haidi.haidimasterdata.api.requests;

import java.util.Objects;

public class AvailabilityRequest {

    private Long id;

    private String day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailabilityRequest that = (AvailabilityRequest) o;
        return Objects.equals(id, that.id) && day.equals(that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day);
    }

    @Override
    public String toString() {
        return "Availability{" +
                "id=" + id +
                ", day='" + day + '\'' +
                '}';
    }
}
