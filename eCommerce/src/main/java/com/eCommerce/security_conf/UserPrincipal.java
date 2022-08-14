/**
 * 
 */
package com.eCommerce.security_conf;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eCommerce.model.UserTRN;

/**
 * @author Akash.d
 *
 */
public class UserPrincipal implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserTRN userTrn;

	@SuppressWarnings("unused")
	private Integer typeid;

	public UserPrincipal(UserTRN user) {
		this.userTrn = user;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return userTrn.getPassword();
	}

	@Override
	public String getUsername() {
		return userTrn.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
