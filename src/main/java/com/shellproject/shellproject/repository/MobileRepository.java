package com.shellproject.shellproject.repository;

import java.util.List;

import com.shellproject.shellproject.models.Manufacturer;
import com.shellproject.shellproject.models.Mobile;

import org.springframework.data.repository.CrudRepository;

public interface MobileRepository extends CrudRepository<Mobile, Integer>{
    Mobile findMobileById(Integer mobileId);
    Mobile findByModelName(String modelName);
    List<Mobile> findByManufacturer(Manufacturer manufacturer);   
}
