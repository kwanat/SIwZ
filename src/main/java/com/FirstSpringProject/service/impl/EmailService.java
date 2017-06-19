package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.model.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by sicluceatlux on 2017-05-28.
 */
@Service public class EmailService {
	@Autowired MailSender mailSender;
	public void sendEmail(CustomerOrder order) {
		String em = order.getCart().getCustomer().getCustomerEmail();
		
		String subject = "Order: from 4W Store";
		StringBuilder content = new StringBuilder();
		content.append("Thank you for shopping with us. ");
		content.append("\nYou can place your payment at: XXXXXXXXXXXXXXXXXXXXXXX");
		content.append("\nWe will begin shipment process as soon as we will receive the money.\nRegards,\nAdmin <3");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject(subject);
		mailMessage.setTo(em);
		mailMessage.setText(content.toString());
		mailSender.send(mailMessage);
	}
}
