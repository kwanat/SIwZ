package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.dao.WarehouseDao;
import com.FirstSpringProject.model.Warehouse;
import com.FirstSpringProject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-29.
 */
@Service
public class WarehouseServiceImpl implements WarehouseService{
	
	@Autowired WarehouseDao warehouseDao;
	
	@Override public Warehouse getWarehouseById(int warehouseId) {
		return warehouseDao.getWarehouseById(warehouseId);
	}
	@Override public Warehouse getWarehouseByName(String name) {
		return warehouseDao.getWarehouseByName(name);
	}
	
	@Override public List<Warehouse> getWarehouseList(){
		return warehouseDao.getWarehouseList();
	}
	
	@Override public void editWarehouse(Warehouse warehouse) {
		warehouseDao.editWarehouse(warehouse);
	}
	
	@Override public void addWarehouse(Warehouse warehouse) {
		warehouseDao.addWarehouse(warehouse);
		
	}
	
	@Override public void deleteWarehouse(Warehouse warehouse) {
		warehouseDao.deleteWarehouse(warehouse);
		
	}
}
