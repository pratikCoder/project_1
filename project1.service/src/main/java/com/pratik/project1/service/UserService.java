package com.pratik.project1.service;

import com.pratik.project1.common.exceptions.CommonException;
import com.pratik.project1.model.UserModel;

public interface UserService {

	public Boolean validateUser(String emailId, String password) throws CommonException;

	public UserAuth getUserAuthorizationByEmailId(String emailId) throws CommonException;

	public UserModel addUser(UserModel userModel) throws CommonException;

	public UserModel updateUser(UserModel userModel) throws CommonException;

	public UserModel resetPassword(String oldPassword, String newPassword, String newConfirmPassword, Long userId)
			throws CommonException;

	public UserModel deleteUser(Long userId) throws CommonException;
}
