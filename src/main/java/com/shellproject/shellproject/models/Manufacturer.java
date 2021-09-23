package com.shellproject.shellproject.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="manufacturer_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer")
    private Collection<Mobile> mobiles;

    @OneToMany(mappedBy = "manufacturer")
    private Collection<Shell> shells;



    /**
     * @return Integer return the manufacturerId
     */
    public Integer getManufacturerId() {
        return id;
    }

    /**
     * @param manufacturerId the manufacturerId to set
     */
    public void setManufacturerId(Integer id) {
        this.id = id;
    }

    /**
     * @return Integer return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
}
