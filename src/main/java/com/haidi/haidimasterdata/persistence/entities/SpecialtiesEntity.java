package com.haidi.haidimasterdata.persistence.entities;


import javax.persistence.*;

@Entity(name="SPECIALTIES")
public class SpecialtiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id")
    public Long specialtyId;

    @Column(name = "specialty_code", nullable = false, unique = true, length = 50)
    public String specialtyDescription;

    @Column(name = "specialty_comments", length = 3000)
    public String comment;



}