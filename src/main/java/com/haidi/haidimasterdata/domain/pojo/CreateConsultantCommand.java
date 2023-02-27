package com.haidi.haidimasterdata.domain.pojo;

import java.util.List;
import java.util.Objects;

public class CreateConsultantCommand {
    private Long technicalId;

    private String userName;

    private String description;

    private List<Specialty> specialty;

    private List<Availability> availabilities;


    private Double  dailyRate;

    public CreateConsultantCommand(String userName, String description, List<Specialty> specialty, List<Availability> availabilities, Double dailyRate) {
        this.userName = userName;
        this.description = description;
        this.specialty = specialty;
        this.availabilities = availabilities;
        this.dailyRate = dailyRate;
    }

    public static CreateConsultantCommand createOne(String userName, String description, List<Specialty> specialty, List<Availability> availabilities, Double dailyRate){
        return new CreateConsultantCommand( userName,  description,  specialty, availabilities,  dailyRate);
    }

    public Long getTechnicalId() {
        return technicalId;
    }

    public void setTechnicalId(Long technicalId) {
        this.technicalId = technicalId;
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

    public List<Specialty> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<Specialty> specialty) {
        this.specialty = specialty;
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<Availability> availabilities) {
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
        CreateConsultantCommand that = (CreateConsultantCommand) o;
        return Objects.equals(technicalId, that.technicalId) && userName.equals(that.userName) && description.equals(that.description) && Objects.equals(specialty, that.specialty) && Objects.equals(availabilities, that.availabilities) && dailyRate.equals(that.dailyRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(technicalId, userName, description, specialty, availabilities, dailyRate);
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "technicalId=" + technicalId +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", specialty=" + specialty +
                ", availabilities=" + availabilities +
                ", dailyRate=" + dailyRate +
                '}';
    }
}
