package com.FirstSpringProject.service;

import com.FirstSpringProject.model.Warehouse;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-29.
 */
public interface WarehouseService {
	
	Warehouse getWarehouseById (int warehouseId);
	
	Warehouse getWarehouseByName(String name);
	
	List<Warehouse> getWarehouseList();
	
	void editWarehouse(Warehouse warehouse);
	
	void addWarehouse(Warehouse warehouse);
	
	void deleteWarehouse(Warehouse warehouse);
}
