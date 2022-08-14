/**
 * 
 */
package com.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eCommerce.model.UserTRN;

/**
 * @author Akash.d
 *
 */
public interface UserRepository extends JpaRepository<UserTRN, Integer> {

	UserTRN findByEmailAndPasswordAndIsActive(String email, String password, String isActive);

	UserTRN findByEmailAndIsActive(String email, String isActive);

}
