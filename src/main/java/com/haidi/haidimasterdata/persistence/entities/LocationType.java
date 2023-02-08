package com.haidi.haidimasterdata.persistence.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="location_type")
public class LocationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="location_type_id")
    public Long id;

    @Column(name ="location_type_description", nullable = false)
    public String description;

    @OneToMany(mappedBy="locationType")
    private List<Locations> locations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationType that = (LocationType) o;

        if (!id.equals(that.id)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LocationType{" +
                "id=" + id +
                ", description=" + description +
                '}';
    }
}
