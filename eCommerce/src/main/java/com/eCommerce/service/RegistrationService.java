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
public interface RegistrationService {

	GenericJsonBean saveUser(UserDTO dto);

}
