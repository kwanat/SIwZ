package com.FirstSpringProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-29.
 */
@Entity
public class Warehouse implements Serializable {
	/**
	 * GUID
	 */
	private static final long serialVersionUID = -5065666447090003398L;
	/**
	 * Warehouse ID
	 */
	@Id
	@GeneratedValue
	private int warehouseId;
	/**
	 * Warehouse name
	 */
	@NotNull
	private String warehouseName;
	
	/**
	 * getter for warehouse ID
	 * @return warehouse ID
	 */
	public int getWarehouseId() {
		return warehouseId;
	}
	
	/**
	 * setter for warehouse name
	 * @return warehouse name
	 */
	public String getWarehouseName() {
		return warehouseName;
	}
	
	/**
	 * setter for warehouse name
	 * @param warehouseName
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	/**
	 * setter for warehouse ID
	 * @param id warehouse ID
	 */
	void setWarehouseId(String id){
		this.warehouseId = Integer.parseInt(id);
	}
}
