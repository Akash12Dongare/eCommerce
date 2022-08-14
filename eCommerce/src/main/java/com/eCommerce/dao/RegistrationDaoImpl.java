/**
 * 
 */
package com.eCommerce.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eCommerce.dto.UserDTO;
import com.eCommerce.model.UserTRN;

/**
 * @author Akash.d
 *
 */
@Repository
public class RegistrationDaoImpl implements RegistrationDao {

	@PersistenceContext
	EntityManager em;

	Query query;

	String m_strQuery;

	@Override
	public void saveUser(UserDTO dto, String password) {
		em.merge(new UserTRN(dto.getEmail(), password, dto.getName(), dto.getGender(), dto.getAge()));

	}

}
