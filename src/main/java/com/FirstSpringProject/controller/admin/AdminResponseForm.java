package com.FirstSpringProject.controller.admin;

import com.FirstSpringProject.model.ContactForm;
import com.FirstSpringProject.model.Customer;
import com.FirstSpringProject.model.ResponseForm;
import com.FirstSpringProject.service.ContactFormService;
import com.FirstSpringProject.service.CustomerService;
import com.FirstSpringProject.service.ResponseFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by sicluceatlux on 2017-05-27.
 */
@Controller @RequestMapping("/admin/responseFormsInventory") public class AdminResponseForm {
	@Autowired private ResponseFormService responseFormService;
	@Autowired private MailSender mailSender;
	@Autowired private CustomerService customerService;
	@Autowired private ContactFormService contactFormService;
	
	
	@RequestMapping("/responseForm/addResponseForm/{contactFormId}")
	public String addContactForm(@PathVariable("contactFormId") int contactFormId,
								 Model model,
								 RedirectAttributes redirectAttributes) {
		ResponseForm responseForm = new ResponseForm();
		ContactForm contactForm = contactFormService.getContactFormById(contactFormId);
		model.addAttribute("contactForm",contactForm);
		Customer customer = customerService.getCustomerById(contactForm.getCustomer().getCustomerId());
		model.addAttribute("customer", customer);
		responseForm.setContactForm(contactForm);
		model.addAttribute("responseForm", responseForm);
		responseForm.setCustomer(customer);
		redirectAttributes.addFlashAttribute("responseForm", responseForm);
		return "addResponseForm";
	}
	
	@RequestMapping(value = "/responseForm/addResponseForm/{contactFormId}", method = RequestMethod.POST)
	public String addContactFormPost(@Valid @PathVariable("contactFormId") int contactFormId, @ModelAttribute
			("responseForm") ResponseForm responseForm,
									 @ModelAttribute("contactForm") ContactForm contactForm,
									 @ModelAttribute("customer") Customer customer,
									 Model model,
									 BindingResult result,
									 HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addResponseForm";
		}
		ContactForm contactForm1 = contactFormService.getContactFormById(contactFormId);
		responseForm.setContactForm(contactForm1);
		responseForm.setResponseFormDate(new Date().toString());
		Customer customer1 = customerService.getCustomerById(contactForm1.getCustomer().getCustomerId());
		responseForm.setCustomer(customer1);

		
		String recipientAddress = customer1.getCustomerEmail();
		
		String subject = responseForm.getResponseFormSubject();
		String message = responseForm.getResponseFormContent();
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		// sends the e-mail
		mailSender.send(email);
		responseFormService.addResponseForm(responseForm);
		return "redirect:/admin/responseFormsInventory";
	}
	
	@RequestMapping("/responseForm/deleteResponseForm/{responseFormId}")
	public String deleteForm(@PathVariable("responseFormId") int responseFormId) {
		
		ResponseForm responseForm = responseFormService.getResponseFormById(responseFormId);
		responseFormService.deleteResponseForm(responseForm);
		
		return "redirect:/admin/responseFormsInventory";
	}
}
