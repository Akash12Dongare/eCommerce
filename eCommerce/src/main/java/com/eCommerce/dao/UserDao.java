/**
 * 
 */
package com.eCommerce.dao;

import com.eCommerce.model.UserTRN;

/**
 * @author Akash.d
 *
 */
public interface UserDao {

	UserTRN getUserDetails(String email, String password);

}
