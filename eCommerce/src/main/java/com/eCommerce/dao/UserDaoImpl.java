/**
 * 
 */
package com.eCommerce.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eCommerce.model.UserTRN;
import com.eCommerce.repository.UserRepository;

/**
 * @author Akash.d
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private UserRepository userRepo;

	Query query;

	String m_strQuery;

	@Override
	public UserTRN getUserDetails(String email, String password) {
		return userRepo.findByEmailAndIsActive(email, "Y");
	}

}
