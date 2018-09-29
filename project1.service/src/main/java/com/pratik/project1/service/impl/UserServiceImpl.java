package com.pratik.project1.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pratik.project1.common.constants.ErrorMessages;
import com.pratik.project1.common.exceptions.CommonException;
import com.pratik.project1.db.entity.UserEntity;
import com.pratik.project1.db.repository.UserJpaRepository;
import com.pratik.project1.model.UserModel;
import com.pratik.project1.service.UserAuth;
import com.pratik.project1.service.UserService;
import com.pratik.project1.service.utils.CommonUtils;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserJpaRepository userJpaRepo;

	@Autowired
	UserAuth userAuth;

	@Autowired
	private ModelMapper modelMapper;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@SuppressWarnings("unused")
	@Override
	public Boolean validateUser(String emailId, String password) throws CommonException {
		Boolean isValidUser = false;
		UserEntity userEntity = null;
		if (emailId.contains("@")) {
			// userEntity = userJpaRepo.getUserByEmailId(emailId);
		}
		if (userEntity == null) {
			logger.error(ErrorMessages.USER_DOES_NOT_EXISTS + emailId);
			throw new CommonException(ErrorMessages.USER_DOES_NOT_EXISTS + emailId);
		} else if (!passwordEncoder.matches(password, userEntity.getPassword())) {
			logger.error(password, ErrorMessages.INVALID_USERNAME_AND_PASSWORD);
			throw new CommonException(ErrorMessages.INVALID_USERNAME_AND_PASSWORD);
		} else {
			isValidUser = true;
		}
		System.out.println("userEntity : " + userEntity);
		System.out.println("isValidUser : " + isValidUser);
		return isValidUser;
	}

	@Override
	public UserAuth getUserAuthorizationByEmailId(String emailId) throws CommonException {

		// UserAuth userAuth = new UserAuthImpl();

		UserEntity userEntity = validateIdAndGetUserEnt(emailId);
		userAuth.setUser(userEntity);

		List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority("USER");
		authoritiesList.add(sga);
		userAuth.setAuthoritiesList(authoritiesList);

		return userAuth;
	}

	private UserEntity validateIdAndGetUserEnt(String emailId) throws CommonException {
		if (!emailId.contains("@")) {
			throw new CommonException(ErrorMessages.USER_EMAIL_INVALID);
		}

		UserEntity userEntity = userJpaRepo.getUserByUserEmailId(emailId);
		// Validtion of user is exists
		// if (userEntity.getIsFirstTimeLogin()) {
		// System.out.println("toString==> " + userEntity.toString());
		// userEntity = updateFirstTimeLogin(userEntity.getUserEmailId());
		// }
		if (userEntity == null) {
			logger.error(ErrorMessages.USER_DOES_NOT_EXISTS + emailId);
			throw new CommonException(ErrorMessages.USER_DOES_NOT_EXISTS + emailId);
		}
		return userEntity;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public UserModel addUser(UserModel userModel) throws CommonException {
		logger.debug("addUser() :: userModel : " + userModel);

		// UserServiceUtils.addUserModelValidate(userModel);

		Date createdDate = CommonUtils.currentDate();

		UserEntity userEntity = new UserEntity();
		userEntity.setCreatedDate(createdDate);
		userEntity.setUpdatedDate(createdDate);

		modelMapper.map(userModel, userEntity);

		String password = userEntity.getPassword();

		String encryptPassword = passwordEncoder.encode(password);

		userEntity.setPassword(encryptPassword);

		userEntity = userJpaRepo.saveAndFlush(userEntity);
		modelMapper.map(userEntity, userModel);
		logger.debug("addUser() end");

		userModel.setConfirmPassword(null);
		userModel.setPassword(null);

		return userModel;
	}

}
