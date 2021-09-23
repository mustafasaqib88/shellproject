package com.shellproject.shellproject.repository;

import java.util.List;

import com.shellproject.shellproject.models.Manufacturer;
import com.shellproject.shellproject.models.Shell;
import org.springframework.data.repository.CrudRepository;

public interface ShellRepository extends CrudRepository<Shell, Integer>{
    List<Shell> findByManufacturer(Manufacturer manufacturer);   
}
