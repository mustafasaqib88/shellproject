package com.shellproject.shellproject.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shellproject.shellproject.models.Manufacturer;
import com.shellproject.shellproject.models.Mobile;
import com.shellproject.shellproject.models.Shell;
import com.shellproject.shellproject.repository.ManufacturerRepository;
import com.shellproject.shellproject.repository.MobileRepository;
import com.shellproject.shellproject.repository.ShellRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShellProjectController {
    private final AtomicLong counter  = new AtomicLong();

    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private MobileRepository mobileRepository;
    @Autowired
    private ShellRepository shellRepository;

    @PostMapping(path="/add-manufacturer")
    public @ResponseBody ResponseEntity<?> addManufacturer(@RequestParam(name="name") String manufactureName){
        Manufacturer manufacturer=new Manufacturer();
        manufacturer.setName(manufactureName);
        manufacturerRepository.save(manufacturer);
        return ResponseEntity.ok("Manufacturer has been added.");
    }

    @GetMapping(path="/all-manufacturers")
    public @ResponseBody Iterable<Manufacturer> getAllManufacturers(){
        return manufacturerRepository.findAll();
    }


    @PostMapping(path="/add-mobile")
    public @ResponseBody ResponseEntity<?> addMobile(@RequestParam(name="model_name") String modelName, @RequestParam(name="model_year") String modelYear, @RequestParam(name="manufacturer_id") Integer manufacturerId){
        Mobile mobile=new Mobile();
        mobile.setModelName(modelName);
        mobile.setModelYear(modelYear);
        mobile.setManufacturer(manufacturerRepository.findManufacturerById(manufacturerId));
        mobileRepository.save(mobile);
        return ResponseEntity.ok("Mobile has been added.");
    }

    @GetMapping(path="/all-mobiles")
    public @ResponseBody Iterable<Mobile> getAllMobiles(){
        return mobileRepository.findAll();
    }

    @PostMapping(path="/add-shell")
    public @ResponseBody ResponseEntity<?> addShell(@RequestParam(name="name") String name, 
    @RequestParam(name="price") Float price,
     @RequestParam(name="manufacturer_id") Integer manufacturerId,
     @RequestParam(name="mobile_id") Integer mobileId){
        Shell shell=new Shell();
        shell.setName(name);
        shell.setPrice(price);
        shell.setManufacturer(manufacturerRepository.findManufacturerById(manufacturerId));
        shell.setMobile(mobileRepository.findMobileById(mobileId));
        shellRepository.save(shell);
        return ResponseEntity.ok("Shell has been added.");
    }

    @GetMapping(path="/all-shells")
    public @ResponseBody Iterable<Shell> getAllShells(){
        return shellRepository.findAll();
    }

    @GetMapping(path="/get-mobiles-by-manufacturer")
    public @ResponseBody Iterable<Mobile> getMobilesByManufacturerName(@RequestParam(name="name") String name){
        Manufacturer manufacturer=manufacturerRepository.findManufacturerByName(name);
        return mobileRepository.findByManufacturer(manufacturer);
    }

    @GetMapping(path="/get-shells-by-manufacturer")
    public @ResponseBody Iterable<Shell> getShellsByManufacturerName(@RequestParam(name="name") String name){
        Manufacturer manufacturer=manufacturerRepository.findManufacturerByName(name);
        return shellRepository.findByManufacturer(manufacturer);
    }

}
