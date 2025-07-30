package com.secuity.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secuity.Config.javaUtils;
import com.secuity.Service.impl.userDetailServiceImpl;
import com.secuity.model.JWTRequest;
import com.secuity.model.JWTResponse;
import com.secuity.model.User;



@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private userDetailServiceImpl userDetailServiceImpl;

	@Autowired
	private javaUtils jwtutils;

	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest) throws Exception {

		try {
			org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			User user = (User) authentication.getPrincipal();
			String token = jwtutils.generateToken(user);
			JWTResponse Response = new JWTResponse(token, user.getUsername(), user.getName(),
					user.getEmail(), user.getPhone());
			return ResponseEntity.ok().body(Response);

		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials" + e.getMessage());
		}

	}

	@GetMapping("/current-user")
	public UserDetails getCurrentUser(Principal principal) {
		return this.userDetailServiceImpl.loadUserByUsername(principal.getName());
	}

}