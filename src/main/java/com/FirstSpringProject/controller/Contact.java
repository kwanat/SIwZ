package com.FirstSpringProject.controller;

import com.FirstSpringProject.model.ContactForm;
import com.FirstSpringProject.model.Users;
import com.FirstSpringProject.service.ContactFormService;
import com.FirstSpringProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by sicluceatlux on 2017-05-26.
 */
@Controller
@RequestMapping("/contact")
public class Contact {
	@Autowired private ContactFormService contactFormService;
	@Autowired private CustomerService customerService;
	@Autowired private JavaMailSender mailSender;
	
	@RequestMapping("/contactForm")
	public String contactForm(Model model){
		ContactForm contactForm = new ContactForm();
		model.addAttribute("contactForm", contactForm);
		return "contactForm";
	}
	
	@RequestMapping("/contactForm/addContactForm")
	public String addContactForm(Model model){
		ContactForm contactForm = new ContactForm();
		
		model.addAttribute("contactForm", contactForm);
		
		return "contactForm";
	}
	
	@RequestMapping(value="/contactForm/addContactForm", method = RequestMethod.POST)
	public String addContactFormPost(@Valid @ModelAttribute("contactForm") ContactForm contactForm,
								 BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()){
			return "ContactForm";
		}
		contactForm.setContactFormDate(new Date().toString());
		String username = request.getUserPrincipal().getName();
		contactForm.setCustomer(customerService.getCustomerByUsername(username));
		contactFormService.addContactForm(contactForm);
		// takes input from e-mail form
		String recipientAddress = "crysplosion@gmail.com";
		String subject = request.getParameter("contactFormSubject");
		String message = request.getParameter("contactFormContent");
		
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
		return "contactThanks";
	}
	
	
	
}
