package com.haidi.haidimasterdata.api.requests;


import java.util.List;
import java.util.Objects;

public class SaveConsultantRequest {
    public  String userName;

    public  String description;

    public  List<SpecialtyRequest> specialtyRequest;

    public  List<AvailabilityRequest> availabilities;


    public  Double  dailyRate;

    public SaveConsultantRequest(String userName, String description, List<SpecialtyRequest> specialtyRequest, List<AvailabilityRequest> availabilities, Double dailyRate) {
        this.userName = userName;
        this.description = description;
        this.specialtyRequest = specialtyRequest;
        this.availabilities = availabilities;
        this.dailyRate = dailyRate;
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

    public List<SpecialtyRequest> getSpecialtyRequest() {
        return specialtyRequest;
    }

    public void setSpecialtyRequest(List<SpecialtyRequest> specialtyRequest) {
        this.specialtyRequest = specialtyRequest;
    }

    public List<AvailabilityRequest> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<AvailabilityRequest> availabilities) {
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
        SaveConsultantRequest that = (SaveConsultantRequest) o;
        return userName.equals(that.userName) && description.equals(that.description) && Objects.equals(specialtyRequest, that.specialtyRequest) && Objects.equals(availabilities, that.availabilities) && dailyRate.equals(that.dailyRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, description, specialtyRequest, availabilities, dailyRate);
    }

    @Override
    public String toString() {
        return "SaveConsultantRequest{" +
                "userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", specialty=" + specialtyRequest +
                ", availabilities=" + availabilities +
                ", dailyRate=" + dailyRate +
                '}';
    }
}
