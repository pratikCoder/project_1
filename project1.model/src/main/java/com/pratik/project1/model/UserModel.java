package com.pratik.project1.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class UserModel {
	@Positive
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long userId;

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userFirstName;

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userLastName;

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userGender;

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userEmailId;

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long userMobileNum;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userAltEmailId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long userAltMobileNum;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userName;

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String password;

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String confirmPassword;

	@JsonIgnore
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean isActive;

	@JsonIgnore
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date createdDate;

	@JsonIgnore
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date updatedDate;

	@JsonIgnore
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date lastLoginDate;

	@JsonIgnore
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date updatedPasswordDate;

	public UserModel() {
		super();
	}

	public UserModel(Long userId, String userFirstName, String userLastName, String userGender, String userEmailId,
			Long userMobileNum, String userAltEmailId, Long userAltMobileNum, String userName, String password,
			String confirmPassword, Boolean isActive, Date createdDate, Date updatedDate, Date lastLoginDate,
			Date updatedPasswordDate) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userGender = userGender;
		this.userEmailId = userEmailId;
		this.userMobileNum = userMobileNum;
		this.userAltEmailId = userAltEmailId;
		this.userAltMobileNum = userAltMobileNum;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.lastLoginDate = lastLoginDate;
		this.updatedPasswordDate = updatedPasswordDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public Long getUserMobileNum() {
		return userMobileNum;
	}

	public void setUserMobileNum(Long userMobileNum) {
		this.userMobileNum = userMobileNum;
	}

	public String getUserAltEmailId() {
		return userAltEmailId;
	}

	public void setUserAltEmailId(String userAltEmailId) {
		this.userAltEmailId = userAltEmailId;
	}

	public Long getUserAltMobileNum() {
		return userAltMobileNum;
	}

	public void setUserAltMobileNum(Long userAltMobileNum) {
		this.userAltMobileNum = userAltMobileNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getUpdatedPasswordDate() {
		return updatedPasswordDate;
	}

	public void setUpdatedPasswordDate(Date updatedPasswordDate) {
		this.updatedPasswordDate = updatedPasswordDate;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userGender=" + userGender + ", userEmailId=" + userEmailId + ", userMobileNum=" + userMobileNum
				+ ", userAltEmailId=" + userAltEmailId + ", userAltMobileNum=" + userAltMobileNum + ", userName="
				+ userName + ", password=" + password + ", confirmPassword=" + confirmPassword + ", isActive="
				+ isActive + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", lastLoginDate="
				+ lastLoginDate + ", updatedPasswordDate=" + updatedPasswordDate + "]";
	}
}
