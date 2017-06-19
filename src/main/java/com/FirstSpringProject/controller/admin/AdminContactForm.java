package com.FirstSpringProject.controller.admin;

import com.FirstSpringProject.model.ContactForm;
import com.FirstSpringProject.model.ResponseForm;
import com.FirstSpringProject.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sicluceatlux on 2017-05-26.
 */
@Controller @RequestMapping(value = "/admin/contactFormsInventory") public class AdminContactForm {
	@Autowired private ContactFormService contactFormService;
	
	@RequestMapping("/contactForm/deleteContactForm/{contactFormId}")
	public String deleteForm(@PathVariable("contactFormId") int contactFormId,
									Model model,
									HttpServletRequest request) {
		
		ContactForm contactForm = contactFormService.getContactFormById(contactFormId);
		contactFormService.deleteContactForm(contactForm);
		
		return "redirect:/admin/contactFormsInventory";
	}
	
	
}
