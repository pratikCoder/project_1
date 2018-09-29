package com.pratik.project1.server.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.pratik.project1.common.constants.ErrorMessages;
import com.pratik.project1.common.exceptions.CommonException;
import com.pratik.project1.service.UserAuth;
import com.pratik.project1.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserService userService;

	@Autowired
	UserAuth userAuth;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	@SuppressWarnings("serial")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		Authentication auth = null;
		String exceptionMessage = "";
		String name = String.valueOf(authentication.getPrincipal());
		System.out.println("name : " + name);
		try {
			Boolean isValidUser = userService.validateUser(name, String.valueOf(authentication.getCredentials()));
			System.out.println("isValidUser : " + isValidUser);
			System.out.println("String.valueOf(authentication.getCredentials()) *******"
					+ String.valueOf(authentication.getCredentials()));
			if (isValidUser) {

				userAuth = userService.getUserAuthorizationByEmailId(name);

				if (!userAuth.getUser().getIsActive()) {
					System.out.println("authenticate **************** in if");
					throw new CommonException(ErrorMessages.USER_IS_INAVCTIV);
				}

				if (!passwordEncoder.matches(String.valueOf(authentication.getCredentials()),
						userAuth.getUser().getPassword())) {
					throw new CommonException(ErrorMessages.INVALID_USERNAME_AND_PASSWORD);
				}
				auth = new UsernamePasswordAuthenticationToken(userAuth.getUser().getUserEmailId(),
						userAuth.getUser().getPassword(), userAuth.getAuthoritiesList());
				System.out.println(auth.toString());
				System.out.println("========================================================================");
			}
		} catch (Exception e) {
			exceptionMessage = e.getMessage().replace("\"", "");
		} finally {
			if (auth == null) {
				logger.error(exceptionMessage);
				throw new AuthenticationException(exceptionMessage) {
				};
			}
		}
		System.out.println("before return auth : " + auth);
		return auth;
	}
}
