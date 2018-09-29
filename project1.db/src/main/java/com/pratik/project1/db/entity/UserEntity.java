package com.pratik.project1.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "userFirstName")
	private String userFirstName;

	@Column(name = "userLastName")
	private String userLastName;

	@Column(name = "userGender")
	private String userGender;

	@Column(name = "userEmailId")
	private String userEmailId;

	@Column(name = "userMobileNum")
	private Long userMobileNum;

	@Column(name = "userAltEmailId")
	private String userAltEmailId;

	@Column(name = "userAltMobileNum")
	private Long userAltMobileNum;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "isActive")
	private Boolean isActive;

	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "updatedDate")
	private Date updatedDate;

	@Column(name = "lastLoginDate")
	private Date lastLoginDate;

	@Column(name = "updatedPasswordDate")
	private Date updatedPasswordDate;

	public UserEntity() {
		super();
	}

	public UserEntity(Long userId, String userFirstName, String userLastName, String userGender, String userEmailId,
			Long userMobileNum, String userAltEmailId, Long userAltMobileNum, String userName, String password,
			Boolean isActive, Date createdDate, Date updatedDate, Date lastLoginDate, Date updatedPasswordDate) {
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
				+ userName + ", password=" + password + ", isActive=" + isActive + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", lastLoginDate=" + lastLoginDate + ", updatedPasswordDate="
				+ updatedPasswordDate + "]";
	}
}
