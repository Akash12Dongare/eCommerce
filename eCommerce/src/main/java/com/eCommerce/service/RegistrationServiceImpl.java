/**
 * 
 */
package com.eCommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eCommerce.constance.Constants;
import com.eCommerce.dao.RegistrationDao;
import com.eCommerce.dto.UserDTO;
import com.eCommerce.utils.CommonUtils;
import com.eCommerce.utils.GenericJsonBean;

/**
 * @author Akash.d
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDao regDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public GenericJsonBean saveUser(UserDTO dto) {
		GenericJsonBean response = null;
		try {
			if (CommonUtils.passwordValidation(dto.getPassword())) {
				String encode = passwordEncoder.encode(dto.getPassword());
				regDao.saveUser(dto, encode);
				response = GenericJsonBean.createJsonString(Constants.SUCCESS, "User created successfully.", dto);

			} else
				response = GenericJsonBean.createJsonString(Constants.ERROR, "Password Incorrect", Constants.PASSWORD_MSG);

		} catch (Exception e) {
			response = GenericJsonBean.createJsonString(Constants.ERROR, e.getMessage(), "");
			e.printStackTrace();
		}
		return response;
	}

}
