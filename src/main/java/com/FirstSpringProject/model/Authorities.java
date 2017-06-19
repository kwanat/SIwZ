package com.FirstSpringProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by sicluceatlux on 2017-03-18.
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhaobin on 4/1/2016.
 * represents Authority
 */
@Entity
public class Authorities {
	
	/**
	 * Id of authority
	 */
	@Id
	@GeneratedValue
	private int authoritiesId;
	/**
	 * username of user to which authority is assigned
	 */
	private String username;
	/**
	 * name of authority
	 */
	private String authority;
	
	/**
	 * getter for authority ID
	 * @return authority ID
	 */
	public int getAuthoritiesId() {
		return authoritiesId;
	}
	
	/**
	 * setter for authority ID
	 * @param authoritiesId id of authority
	 */
	public void setAuthoritiesId(int authoritiesId) {
		this.authoritiesId = authoritiesId;
	}
	
	/**
	 * getter for username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * setter for username
	 * @param username username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * getter for authority name
	 * @return authority name
	 */
	public String getAuthority() {
		return authority;
	}
	
	/**
	 * setter for authority name
	 * @param authority authority name
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}