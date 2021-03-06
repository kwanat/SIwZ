package com.FirstSpringProject.service;

import com.FirstSpringProject.model.Manufacturer;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-06-03.
 */
public interface ManufacturerService {
	Manufacturer getManufacturerById(int manufacturerId);
	
	List<Manufacturer> getAllManufacturers();
	
	Manufacturer getManufacturerByName(String Name);
}
