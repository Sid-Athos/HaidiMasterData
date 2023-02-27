package com.haidi.haidimasterdata.persistence.entities;

import javax.persistence.*;


import java.util.List;
import java.util.Objects;

@Entity(name = "CONSULTANTS")
public class ConsultantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arch_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String userName;

    @Column(nullable = false, length = 1000, unique = true)
    private String description;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "specialtyId")
    private List<SpecialtiesEntity> specialty;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "availabilityId")
    private List<AvailabilitiesEntity> availabilities;


    @Column(name ="daily_rate")
    private Double  dailyRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SpecialtiesEntity> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<SpecialtiesEntity> specialty) {
        this.specialty = specialty;
    }

    public List<AvailabilitiesEntity> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<AvailabilitiesEntity> availabilities) {
        this.availabilities = availabilities;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultantsEntity that = (ConsultantsEntity) o;
        return id.equals(that.id) && userName.equals(that.userName) && Objects.equals(description, that.description) && Objects.equals(specialty, that.specialty) && Objects.equals(availabilities, that.availabilities) && dailyRate.equals(that.dailyRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, description, specialty, availabilities, dailyRate);
    }

    @Override
    public String toString() {
        return "ConsultantsEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", specialty=" + specialty +
                ", availabilities=" + availabilities +
                ", dailyRate=" + dailyRate +
                '}';
    }
}
