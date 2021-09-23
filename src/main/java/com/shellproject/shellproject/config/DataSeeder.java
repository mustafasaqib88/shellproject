package com.shellproject.shellproject.config;

import com.shellproject.shellproject.models.Manufacturer;
import com.shellproject.shellproject.models.Mobile;
import com.shellproject.shellproject.models.Shell;
import com.shellproject.shellproject.models.User;
import com.shellproject.shellproject.repository.ManufacturerRepository;
import com.shellproject.shellproject.repository.MobileRepository;
import com.shellproject.shellproject.repository.ShellRepository;
import com.shellproject.shellproject.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    MobileRepository mobileRepository;

    @Autowired
    ShellRepository shellRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception{
        loadData();
    }

    private void loadData(){

        User user=new User();
        user.setEmail("user.email@gmail.com");
        user.setUsername("user.email");
        user.setPassword(bcryptEncoder.encode("user.email.88"));
        userRepository.save(user);

        Manufacturer manufacturer=new Manufacturer();
        manufacturer.setName("Xiaomi");
        manufacturerRepository.save(manufacturer);

        manufacturer=new Manufacturer();
        manufacturer.setName("Samsung");
        manufacturerRepository.save(manufacturer);

        manufacturer=new Manufacturer();
        manufacturer.setName("Sony");
        manufacturerRepository.save(manufacturer);

        manufacturer=new Manufacturer();
        manufacturer.setName("Nokia");
        manufacturerRepository.save(manufacturer);

        manufacturer=new Manufacturer();
        manufacturer.setName("Apple");
        manufacturerRepository.save(manufacturer);


        Mobile mobile=new Mobile();
        mobile.setModelName("Redmi Note 9");
        mobile.setModelYear("2020");
        mobile.setManufacturer(manufacturerRepository.findManufacturerByName("Xiaomi"));
        mobileRepository.save(mobile);

        mobile=new Mobile();
        mobile.setModelName("Redmi Note 10");
        mobile.setModelYear("2021");
        mobile.setManufacturer(manufacturerRepository.findManufacturerByName("Xiaomi"));
        mobileRepository.save(mobile);

        mobile=new Mobile();
        mobile.setModelName("Redmi Note 11");
        mobile.setModelYear("2022");
        mobile.setManufacturer(manufacturerRepository.findManufacturerByName("Xiaomi"));
        mobileRepository.save(mobile);

        mobile=new Mobile();
        mobile.setModelName("Galaxy Note 10");
        mobile.setModelYear("2020");
        mobile.setManufacturer(manufacturerRepository.findManufacturerByName("Samsung"));
        mobileRepository.save(mobile);

        mobile=new Mobile();
        mobile.setModelName("Galaxy Note 11");
        mobile.setModelYear("2021");
        mobile.setManufacturer(manufacturerRepository.findManufacturerByName("Samsung"));
        mobileRepository.save(mobile);

        mobile=new Mobile();
        mobile.setModelName("Galaxy Note 12");
        mobile.setModelYear("2022");
        mobile.setManufacturer(manufacturerRepository.findManufacturerByName("Samsung"));
        mobileRepository.save(mobile);

        mobile=new Mobile();
        mobile.setModelName("iPhone 8");
        mobile.setModelYear("2018");
        mobile.setManufacturer(manufacturerRepository.findManufacturerByName("Apple"));
        mobileRepository.save(mobile);

        mobile=new Mobile();
        mobile.setModelName("iPhone 9");
        mobile.setModelYear("2019");
        mobile.setManufacturer(manufacturerRepository.findManufacturerByName("Apple"));
        mobileRepository.save(mobile);

        Shell shell =new Shell();
        shell.setName("Hard Shell 1");
        shell.setPrice(25.5f);
        shell.setManufacturer(manufacturerRepository.findManufacturerByName("Xiaomi"));
        shell.setMobile(mobileRepository.findByModelName("Redmi Note 9"));
        shellRepository.save(shell);

        shell =new Shell();
        shell.setName("Hard Shell 2");
        shell.setPrice(25.5f);
        shell.setManufacturer(manufacturerRepository.findManufacturerByName("Xiaomi"));
        shell.setMobile(mobileRepository.findByModelName("Redmi Note 10"));
        shellRepository.save(shell);

        shell =new Shell();
        shell.setName("Hard Shell 3");
        shell.setPrice(25.5f);
        shell.setManufacturer(manufacturerRepository.findManufacturerByName("Xiaomi"));
        shell.setMobile(mobileRepository.findByModelName("Redmi Note 11"));
        shellRepository.save(shell);

    }
    
}
