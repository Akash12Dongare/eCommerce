/**
 * 
 */
package com.eCommerce.security_conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.eCommerce.service.UserService;

/**
 * @author Akash.d
 *
 */
@Component
public class CustAuthProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		boolean is_active = userService.userValidation(username, password);
		if (is_active) {
			final List<GrantedAuthority> grantedAuthority = new ArrayList<>();
			final UserDetails principal = new User(username, password, grantedAuthority);
			final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuthority);
			return auth;
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
