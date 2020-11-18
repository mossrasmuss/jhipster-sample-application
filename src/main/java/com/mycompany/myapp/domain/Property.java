package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Property.
 */
@Entity
@Table(name = "property")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_area")
    private Long totalArea;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @ManyToMany(mappedBy = "properties")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<Category> categories = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalArea() {
        return totalArea;
    }

    public Property totalArea(Long totalArea) {
        this.totalArea = totalArea;
        return this;
    }

    public void setTotalArea(Long totalArea) {
        this.totalArea = totalArea;
    }

    public String getDescription() {
        return description;
    }

    public Property description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public Property status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Property categories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Property addCategory(Category category) {
        this.categories.add(category);
        category.getProperties().add(this);
        return this;
    }

    public Property removeCategory(Category category) {
        this.categories.remove(category);
        category.getProperties().remove(this);
        return this;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Property)) {
            return false;
        }
        return id != null && id.equals(((Property) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Property{" +
            "id=" + getId() +
            ", totalArea=" + getTotalArea() +
            ", description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
