package com.FirstSpringProject.service;

import com.FirstSpringProject.model.ResponseForm;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-05-26.
 */
public interface ResponseFormService {
	List<ResponseForm> getResponseFormList();
	ResponseForm getResponseFormById(int id);
	void addResponseForm(ResponseForm responseForm);
	void deleteResponseForm(ResponseForm responseForm);
}
