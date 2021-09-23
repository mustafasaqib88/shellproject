package com.shellproject.shellproject.repository;

import com.shellproject.shellproject.models.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer>{
    Manufacturer findManufacturerById(Integer manufacturerId);
    Manufacturer findManufacturerByName(String name);
}
