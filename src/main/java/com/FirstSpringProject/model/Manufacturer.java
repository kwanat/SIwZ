package com.FirstSpringProject.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sicluceatlux on 2017-06-03.
 */
@Entity
public class Manufacturer implements Serializable {
	/**
	 * GUID
	 */
	private static final long serialVersionUID = 832594151340819962L;
	/**
	 * manufacturer ID
	 */
	@Id
	@GeneratedValue
	private int manufacturerId;
	/**
	 * manufacturer name
	 */
	private String manufacturerName;
	/**
	 * manufacturer regon
	 */
	private String regon;
	/**
	 * manufacturer nip
	 */
	private String nip;
	
	/**
	 * getter for manufacturer ID
	 * @return manufacturer ID
	 */
	public int getManufacturerId() {
		return manufacturerId;
	}
	
	/**
	 * setter for manufacturer ID
	 * @param manufacturerId
	 */
	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	
	/**
	 * getter for manufacturer name
	 * @return manufacturer name
	 */
	public String getManufacturerName() {
		return manufacturerName;
	}
	
	/**
	 * setter for manufacturer name
	 * @param manufacturerName
	 */
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	
	/**
	 * getter for REGON
 	 * @return REGON
	 */
	public String getRegon() {
		return regon;
	}
	
	/**
	 * setter for REGON
	 * @param regon REGON
	 */
	public void setRegon(String regon) {
		this.regon = regon;
	}
	
	/**
	 * getter for NIP
	 * @return NIP
	 */
	public String getNip() {
		return nip;
	}
	
	/**
	 * setter for NIP
	 * @param nip
	 */
	public void setNip(String nip) {
		this.nip = nip;
	}
}
