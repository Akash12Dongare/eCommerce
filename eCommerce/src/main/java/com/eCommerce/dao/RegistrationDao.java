/**
 * 
 */
package com.eCommerce.dao;

import com.eCommerce.dto.UserDTO;

/**
 * @author Akash.d
 *
 */
public interface RegistrationDao {

	void saveUser(UserDTO dto, String password);

}
