package com.shellproject.shellproject.models;

import java.time.Year;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mobile")
public class Mobile {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="mobile_id")
    private Integer id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name="model_year")
    private String modelYear;

    @ManyToOne
    @JoinColumn(name="manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "mobile")
    private Collection<Shell> shells;
       

    /**
     * @return Integer return the mobileId
     */
    public Integer getMobileId() {
        return id;
    }

    /**
     * @param id the mobileId to set
     */
    public void setMobileId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName the modelName to set
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return Year return the modelYear
     */
    public String getModelYear() {
        return modelYear;
    }

    /**
     * @param modelYear the modelYear to set
     */
    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    /**
     * @return Manufacturer return the manufacturer
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return Collection<Shell> return the shells
     */
    public Collection<Shell> getShells() {
        return shells;
    }

    /**
     * @param shells the shells to set
     */
    public void setShells(Collection<Shell> shells) {
        this.shells = shells;
    }

}
