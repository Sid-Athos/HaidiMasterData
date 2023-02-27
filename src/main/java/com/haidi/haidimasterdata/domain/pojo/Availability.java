package com.haidi.haidimasterdata.domain.pojo;

import java.util.Objects;

public class Availability {

    private Long id;

    private AvailableDays day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AvailableDays getDay() {
        return day;
    }

    public void setDay(AvailableDays day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Availability that = (Availability) o;
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
