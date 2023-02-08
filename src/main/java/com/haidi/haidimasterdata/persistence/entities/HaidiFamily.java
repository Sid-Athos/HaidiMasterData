package com.haidi.haidimasterdata.persistence.entities;


import com.haidi.haidimasterdata.domain.pojo.Product;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="family")
public class HaidiFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_id")
    public Long id;

    @Column(name = "family_description", nullable = false)
    public String description;

    @Column(name = "parent_family_id")
    public Long parentId;

    @OneToMany(mappedBy="family")
    private List<ProductsEntity> product;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HaidiFamily that = (HaidiFamily) o;

        if (!id.equals(that.id)) return false;
        if (!description.equals(that.description)) return false;
        return Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HaidiFamily{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                '}';
    }

}