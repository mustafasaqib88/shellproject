package com.shellproject.shellproject.controller;

import com.shellproject.shellproject.config.JwtTokenUtil;
import com.shellproject.shellproject.models.User;
import com.shellproject.shellproject.repository.UserRepository;
import com.shellproject.shellproject.requests.JwtRequest;
import com.shellproject.shellproject.requests.RegisterRequest;
import com.shellproject.shellproject.responses.JwtResponse;
import com.shellproject.shellproject.service.JwtUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @RequestMapping(value="/authenticate",method=RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationEntity(@RequestBody JwtRequest authenticationRequest) throws Exception {
        
        System.out.println(authenticationRequest.getPassword());
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));

    }

    private void authenticate(String username, String password) throws Exception {
		try {
			Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("is authentication "+authentication.isAuthenticated());
            System.out.println("authenticate run");
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		} catch(Exception e){
            System.out.println("authenticate failed");

        }
	}


    @RequestMapping(value="/register",method=RequestMethod.POST)
    public @ResponseBody String registerUser(@RequestBody RegisterRequest registerRequest) throws Exception {
        
        register(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getEmail());
        return "User Registered";
    }

    private void register(String username, String password, String email) throws Exception {
        User user=new User();
        user.setUsername(username);
        user.setPassword(bcryptEncoder.encode(password));
        user.setEmail(email);
        userRepository.save(user);
        
	}


}
