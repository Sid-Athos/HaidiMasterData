package com.haidi.haidimasterdata.persistence.entities;



import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AvailabilitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "availability_id")
    public Long availabilityId;

    @Column(name="day_code", nullable = false, unique = true)
    public String day;

}
