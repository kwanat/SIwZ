package com.FirstSpringProject.dao;

import com.FirstSpringProject.model.Warehouse;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-29.
 */
public interface WarehouseDao {
	
	Warehouse getWarehouseById (int warehouseId);
	
	Warehouse getWarehouseByName(String warehouseName);
	
	List<Warehouse> getWarehouseList();
	
	void editWarehouse(Warehouse warehouse);
	
	void addWarehouse(Warehouse warehouse);
	
	void deleteWarehouse(Warehouse warehouse);
}
