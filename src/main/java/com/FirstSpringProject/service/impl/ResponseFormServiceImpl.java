package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.dao.ResponseFormDao;
import com.FirstSpringProject.model.ResponseForm;
import com.FirstSpringProject.service.ResponseFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-05-26.
 */
@Service
public class ResponseFormServiceImpl implements ResponseFormService {
	@Autowired private ResponseFormDao responseFormDao;
	
	@Override public List<ResponseForm> getResponseFormList() {
		return responseFormDao.getResponseFormList();
	}
	
	@Override public ResponseForm getResponseFormById(int id) {
		return responseFormDao.getResponseFormById(id);
	}
	
	@Override public void addResponseForm(ResponseForm responseForm) {
		responseFormDao.addResponseForm(responseForm);
	}
	
	@Override public void deleteResponseForm(ResponseForm responseForm) {
		responseFormDao.deleteResponseForm(responseForm);
	}
}
