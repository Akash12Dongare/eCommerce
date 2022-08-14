/**
 * 
 */
package com.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.constance.Constants;
import com.eCommerce.dto.UserDTO;
import com.eCommerce.service.UserService;
import com.eCommerce.utils.GenericJsonBean;

/**
 * @author Akash.d
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user-module/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping(value = "authentication")
	public GenericJsonBean authentication(@RequestBody UserDTO dto) {
		GenericJsonBean response = null;
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
			response = userService.getUserDetails(dto);
		} catch (Exception e) {
			response = GenericJsonBean.createJsonString(Constants.ERROR, "User name or password does not exit", "");
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping(value = "tokenExpired")
	public GenericJsonBean tokenExpired() {
		return GenericJsonBean.createJsonString(Constants.ERROR, "Token expired.", "");
	}

}
