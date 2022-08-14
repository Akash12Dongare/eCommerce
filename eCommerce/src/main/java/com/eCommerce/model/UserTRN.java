/**
 * 
 */
package com.eCommerce.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Akash.d
 *
 */
@Entity
@Table(name = "user_trn")
public class UserTRN implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "pk_id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkId;

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "password", insertable = true, updatable = false)
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "age")
	private Integer age;

	@Column(name = "is_active", insertable = true, updatable = false)
	private String isActive = "Y";

	@Column(name = "created_on", insertable = true, updatable = false)
	private String createdOn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

	@Column(name = "updated_on", insertable = false, updatable = true)
	private String updatedOn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

	public UserTRN() {

	}

	public UserTRN(String email, String password, String name, String gender, Integer age) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public Integer getPkId() {
		return pkId;
	}

	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserTRN [pkId=" + pkId + ", email=" + email + ", password=" + password + ", name=" + name + ", gender="
				+ gender + ", age=" + age + ", isActive=" + isActive + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}

}
