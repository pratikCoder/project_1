package com.pratik.project1.server.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	public static final String CHECK_TOKEN_ACCESS_IS_AUTHENTICATED = "isAuthenticated()";
	public static final String CHECK_TOKEN_ACCESS_PERMIT_ALL = "permitAll()";
	public static final String CLIENT_ID = "my-client";
	public static final String GRANT_TYPE_PASSWORD = "password";
	public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
	public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
	public static final String GRANT_TYPE_IMPLICIT = "implicit";
	public static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
	public static final String AUTHORITIES_ROLE_CLIENT = "ROLE_CLIENT";
	public static final String AUTHORITIES_ROLE_TRUSTED_CLIENT = "ROLE_TRUSTED_CLIENT";
	public static final String AUTHORITIES_ROLE_USER = "ROLE_USER";
	public static final String AUTHORITIES_ROLE_ADMIN = "ROLE_ADMIN";
	public static final String SCOPE_READ = "read";
	public static final String SCOPE_WRITE = "write";
	public static final String SCOPE_TRUST = "trust";
	public static final String RESOURCE_ID = "oauth2-resource";
	public static final Integer ACCESS_TOKEN_VALIDITY_SECONDS = 86400;
	public static final Integer REFRESH_TOKEN_VALIDITY_SECONDS = 86400;
	public static final String CLIENT_SECRET = "{noop}secret";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private DataSource dataSource;

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Bean
	protected AuthorizationCodeServices authorizationCodeServices() {
		return new JdbcAuthorizationCodeServices(dataSource);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess(CHECK_TOKEN_ACCESS_PERMIT_ALL).checkTokenAccess(CHECK_TOKEN_ACCESS_IS_AUTHENTICATED);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		try {
			clients.jdbc(dataSource).build().loadClientByClientId(CLIENT_ID);
		} catch (NoSuchClientException e) {
			clients.jdbc(dataSource).withClient(CLIENT_ID)
					.authorizedGrantTypes(GRANT_TYPE_PASSWORD, GRANT_TYPE_AUTHORIZATION_CODE, GRANT_TYPE_REFRESH_TOKEN,
							GRANT_TYPE_IMPLICIT, GRANT_TYPE_CLIENT_CREDENTIALS)
					.authorities(AUTHORITIES_ROLE_CLIENT, AUTHORITIES_ROLE_TRUSTED_CLIENT)
					.scopes(SCOPE_READ, SCOPE_WRITE, SCOPE_TRUST).resourceIds(RESOURCE_ID)
					.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
					.refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS).secret(CLIENT_SECRET);
		}
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(this.authenticationManager).tokenStore(tokenStore()).approvalStoreDisabled();
	}
}