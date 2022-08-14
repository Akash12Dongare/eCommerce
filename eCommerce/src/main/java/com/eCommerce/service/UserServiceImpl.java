/**
 * 
 */
package com.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eCommerce.dao.UserDao;
import com.eCommerce.dto.UserDTO;
import com.eCommerce.json_web_token.JWTUtils;
import com.eCommerce.model.UserTRN;
import com.eCommerce.utils.GenericJsonBean;

/**
 * @author Akash.d
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private JWTUtils jwtUtils;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public GenericJsonBean getUserDetails(UserDTO dto) {
		UserTRN bean = userDao.getUserDetails(dto.getEmail(), dto.getPassword());
		GenericJsonBean response = GenericJsonBean.createJsonString(jwtUtils.generateToken(dto.getEmail()), "success",
				"Authentication successfully.", bean);
		return response;
	}

	@Override
	public boolean userValidation(String username, String password) {
		UserTRN bean = userDao.getUserDetails(username, password);
		return passwordEncoder.matches(password, bean.getPassword());
	}

}
