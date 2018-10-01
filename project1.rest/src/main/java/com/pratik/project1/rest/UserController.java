package com.pratik.project1.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.project1.common.exceptions.CommonException;
import com.pratik.project1.model.UserModel;
import com.pratik.project1.service.UserService;

@RestController
@RequestMapping(value = "/user", produces = { "application/JSON" })
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModelReq) throws Exception {
		logger.debug("addUser() :: userModel : " + userModelReq);

		userModelReq.setUserId(null);
		userModelReq.setIsActive(true);
		logger.debug("addUser() :: userModel : " + userModelReq);

		UserModel userModelRes;

		try {
			userModelRes = userService.addUser(userModelReq);
			logger.debug("addUser() :: userModel : {}", userModelRes);
		} catch (CommonException e) {
			logger.error("addUser() :: UserServiceException : {}", e);
			return new ResponseEntity(e.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModelRes, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<UserModel> updateUser(@RequestBody UserModel userModelReq) throws Exception {
		logger.debug("updateUser() :: userModel : " + userModelReq);

		userModelReq.setIsActive(true);
		logger.debug("updateUser() :: userModel : " + userModelReq);

		UserModel userModelRes;

		try {
			userModelRes = userService.updateUser(userModelReq);
			logger.debug("updateUser() :: userModel : {}", userModelRes);
		} catch (CommonException e) {
			logger.error("updateUser() :: UserServiceException : {}", e);
			return new ResponseEntity(e.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModelRes, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<UserModel> deleteUser(@RequestParam Long userId) throws Exception {
		logger.debug("deleteUser() :: userId : " + userId);

		UserModel userModelRes;
		try {
			userModelRes = userService.deleteUser(userId);
			logger.debug("deleteUser() :: userModel : {}", userModelRes);
		} catch (CommonException e) {
			logger.error("deleteUser() :: UserServiceException : {}", e);
			return new ResponseEntity(e.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModelRes, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<UserModel> resetPassword(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String newConfirmPassword, @RequestParam Long userId) throws Exception {
		logger.debug("resetPassword() :: userId : {}, oldPassword : {}, newPassword : {}, newConfirmPassword : {}, ",
				userId, oldPassword, newPassword, newConfirmPassword);

		UserModel userModelRes;
		try {
			userModelRes = userService.resetPassword(oldPassword, newPassword, newConfirmPassword, userId);
			logger.debug("resetPassword() :: userModel : {}", userModelRes);
		} catch (CommonException e) {
			logger.error("resetPassword() :: UserServiceException : {}", e);
			return new ResponseEntity(e.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModelRes, HttpStatus.OK);
	}

}
