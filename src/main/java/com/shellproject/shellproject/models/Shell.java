package com.shellproject.shellproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shell")
public class Shell {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="shell_id")
    private Integer shellId;

    @Column(name = "name")
    private String name;

    @Column(name="price")
    private Float price;

    @ManyToOne
    @JoinColumn(name="manufacturer_id")
    private Manufacturer manufacturer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="mobile_id")
    private Mobile mobile;
    
    
    /**
     * @return Integer return the shellId
     */
    public Integer getShellId() {
        return shellId;
    }

    /**
     * @param shellId the shellId to set
     */
    public void setShellId(Integer shellId) {
        this.shellId = shellId;
    }

    /**
     * @return String return the name
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

    /**
     * @return Float return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
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
     * @return Mobile return the mobile
     */
    public Mobile getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

}
