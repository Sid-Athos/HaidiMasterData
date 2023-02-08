package com.haidi.haidimasterdata.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name="uom")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uom_id")
    public Long id;

    @Column(name = "uom_code")
    public String code;

    @Column(name = "uom_descripti" +
            "on")
    public String description;

}
