package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.model.Warehouse;
import com.FirstSpringProject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by sicluceatlux on 2017-06-04.
 */
public class WarehouseConverter implements Converter<String, Warehouse> {
	
	@Autowired WarehouseService warehouseService;
	
	public Warehouse convert(String name) {
		return warehouseService.getWarehouseByName(name);
	}
}
