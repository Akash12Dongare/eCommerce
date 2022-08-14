/**
 * 
 */
package com.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.dto.UserDTO;
import com.eCommerce.service.RegistrationService;
import com.eCommerce.utils.GenericJsonBean;

/**
 * @author Akash.d
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user-registration/")
public class RegistrationController {

	@Autowired
	private RegistrationService regService;

	@PostMapping(value = "saveUser")
	public GenericJsonBean saveUser(@RequestBody UserDTO dto) {
		return regService.saveUser(dto);
	}

}
