package com.pratik.project1.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.pratik.project1.db.entity.UserEntity;

public interface UserAuth {
	UserEntity getUser();

	void setUser(UserEntity user);

	public void setAuthoritiesList(List<GrantedAuthority> authoritiesList);

	public List<GrantedAuthority> getAuthoritiesList();

}
