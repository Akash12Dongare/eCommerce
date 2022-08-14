/**
 * 
 */
package com.eCommerce.json_web_token;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.eCommerce.model.UserTRN;
import com.eCommerce.repository.UserRepository;
import com.eCommerce.security_conf.UserPrincipal;

/**
 * @author Akash.d
 *
 */
@Component
public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtils jwtUtils;

	@Autowired
	private UserRepository userRepo;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String autherizationHeader = request.getHeader("Authorization");
			String token = null;
			String username = null;

			if (autherizationHeader != null && autherizationHeader.startsWith("Bearer ")) {
				token = autherizationHeader.substring(7);
				username = jwtUtils.extractUsername(token);
			}

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				if (jwtUtils.validateToken(token, username)) {

					UserTRN user = userRepo.findByEmailAndIsActive(username, "Y");
					UserPrincipal userDetails = new UserPrincipal(user);

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

				}
			}
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/user-module/tokenExpired");
			dispatcher.forward(request, response);
			return;
		}
		filterChain.doFilter(request, response);
	}

}
