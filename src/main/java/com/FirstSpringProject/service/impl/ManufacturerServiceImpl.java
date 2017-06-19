package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.dao.ManufacturerDao;
import com.FirstSpringProject.model.Manufacturer;
import com.FirstSpringProject.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-06-03.
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService{
	@Autowired private ManufacturerDao manufacturerDao;
	
	@Override public Manufacturer getManufacturerById(int manufacturerId) {
		return manufacturerDao.getManufacturerById(manufacturerId);
	}
	
	@Override public List<Manufacturer> getAllManufacturers() {
		return manufacturerDao.getAllManufacturers();
	}
	
	@Override public Manufacturer getManufacturerByName(String Name) {
		return manufacturerDao.getManufacturerByName(Name);
	}
}
