package com.shellproject.shellproject.repository;
import java.util.List;

import com.shellproject.shellproject.models.Manufacturer;
import com.shellproject.shellproject.models.Shell;
import com.shellproject.shellproject.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findByUsername(String username);
    
}
