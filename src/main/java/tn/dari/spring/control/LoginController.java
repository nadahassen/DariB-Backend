package tn.dari.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.jwt.JWTUtility;
import tn.dari.spring.jwt.JwtRequest;
import tn.dari.spring.jwt.JwtResponse;
import tn.dari.spring.service.UserService;
import tn.dari.spring.service.UserServiceImpl;
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class LoginController {

	  @Autowired
	    private JWTUtility jwtUtility;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserServiceImpl userService;


	    @PostMapping("/login")
	    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            jwtRequest.getUsername(),
	                            jwtRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }

	        final UserDetails userDetails
	                = userService.loadUserByUsername(jwtRequest.getUsername());

	        final String token =
	                jwtUtility.generateToken(userDetails);
	        log.info("username {}"+jwtRequest.getUsername());
	        return  new JwtResponse(token,jwtRequest.getUsername());
	    }
	    
	    
}
