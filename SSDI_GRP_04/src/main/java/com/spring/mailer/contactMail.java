package com.spring.mailer;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class contactMail{
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}


	public void sendMailContact(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("uncc.apartments@gmail.com");
		message.setTo(to);
		message.setSubject("Comment Submitted");
		message.setText("Thank you for your interest in UNCC Apartments. \n Finding a new home is important and sometimes challenging decision. Please let us know if you have any particular querry! We will get in touch with you soon.\n Regards,\nThe team of UNCC Apartments");
		mailSender.send(message);
		
		SimpleMailMessage message1 = new SimpleMailMessage();
		message1.setFrom("uncc.apartments@gmail.com");
		message1.setTo("uncc.apartments@gmail.com");
		message1.setSubject("A new potential customer is here!");
		message1.setText("Hello Manager,\n A new customer enquired about our apartment, lets get in touch with them!\n Email ID:"+to + "\n\nThanks");
		mailSender.send(message1);
	}
	
	public void sendMailRequest_submitted(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("uncc.apartments@gmail.com");
		message.setTo(to);
		message.setSubject("Request for renewing lease lodged");
		message.setText("Thank you for choosing UNCC apartment for your further stay. We will get back to you with status update on your request. \n Regards,\nThe team of UNCC Apartments");
		mailSender.send(message);
	}
	
	public void sendMailRequest_approved(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("uncc.apartments@gmail.com");
		message.setTo(to);
		message.setSubject("Renew lease request approved");
		message.setText("Congratulations!!!\n Your request for renewing lease has been approved. Please visit leasing office inorder to know more on your billing for renewal period.\n Regards,\nThe team of UNCC Apartments");
		mailSender.send(message);
	}
	
	public void sendMailRequest_rejected(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("uncc.apartments@gmail.com");
		message.setTo(to);
		message.setSubject("Renew lease request reject");
		message.setText("We are sorry to say that your request for renewal of this apartment has been rejected for current extension. /n We strongly recommed you to visit our leasing office to know if there are any other apartments available.\n Regards,\nThe team of UNCC Apartments");
		mailSender.send(message);
	}
}
