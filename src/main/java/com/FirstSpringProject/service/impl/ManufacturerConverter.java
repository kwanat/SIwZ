package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.model.Manufacturer;
import com.FirstSpringProject.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by sicluceatlux on 2017-06-04.
 */
public class ManufacturerConverter implements Converter<String, Manufacturer> {
	@Autowired ManufacturerService manufacturerService;
	
	@Override public Manufacturer convert(String name) {
		return manufacturerService.getManufacturerByName(name);
	}
}
