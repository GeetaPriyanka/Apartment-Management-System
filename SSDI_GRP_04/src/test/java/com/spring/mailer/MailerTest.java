package com.spring.mailer;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.BeforeClass;
import org.junit.Test;

public class MailerTest {
	
	private static SimpleMailMessage message;
	private static MailSender mailSender;
	private static contactMail contactmailmock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		message = mock(SimpleMailMessage.class);
		mailSender=mock(MailSender.class);
		contactmailmock=mock(contactMail.class);
		message=new SimpleMailMessage();
		message.setFrom("uncc.apartments@gmail.com");
	}

	@Test
	public void sendMailContactTest() {
		message.setText("Thank you for your interest in UNCC Apartments. \n Finding a new home is important and sometimes challenging decision. Please let us know if you have any particular querry! We will get in touch with you soon.\n Regards,\nThe team of UNCC Apartments");
		message.setSubject("Comment Submitted");

		contactmailmock.sendMailContact("hhundiwala@gmail.com");
		assertEquals("Comment Submitted",message.getSubject());
		assertEquals("Thank you for your interest in UNCC Apartments. \n Finding a new home is important and sometimes challenging decision. Please let us know if you have any particular querry! We will get in"
				+ " touch with you soon.\n Regards,\nThe team of UNCC Apartments",message.getText());
		
	}

	@Test
	public void testsendMailRequest_submitted()
	{
		message.setText("Thank you for choosing UNCC apartment for your further stay. We will get back to you with status update on your request. \n Regards,\nThe team of UNCC Apartments");
		message.setSubject("Request for renewing lease lodged");
		contactmailmock.sendMailRequest_submitted("hhundiwala@gmail.com");
		assertEquals("Request for renewing lease lodged",message.getSubject());
		assertEquals("Thank you for choosing UNCC apartment for your further stay. We will get back to you with status update on your request. \n Regards,\nThe team of UNCC Apartments",message.getText());
		
	}
	
	@Test
	public void testsendMailRequest_approved()
	{
		message.setText("Congratulations!!!\n Your request for renewing lease has been approved. Please visit leasing office inorder to know more on your billing for renewal period.\n Regards,\nThe team of UNCC Apartments");
		message.setSubject("Renew lease request approved");
		contactmailmock.sendMailRequest_approved("hhundiwala@gmail.com");
		assertEquals("Renew lease request approved",message.getSubject());

		assertEquals("Congratulations!!!\n Your request for renewing lease has been approved. Please visit leasing office inorder to know more on your billing for renewal period.\n Regards,\nThe team of UNCC Apartments",message.getText());
	}
}
