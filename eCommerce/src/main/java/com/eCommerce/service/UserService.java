/**
 * 
 */
package com.eCommerce.service;

import com.eCommerce.dto.UserDTO;
import com.eCommerce.utils.GenericJsonBean;

/**
 * @author Akash.d
 *
 */
public interface UserService {

	GenericJsonBean getUserDetails(UserDTO dto);

	boolean userValidation(String username, String password);

}
