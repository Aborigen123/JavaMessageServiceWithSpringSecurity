package jms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jms.securty.mail.Mail;
import jms.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired private JavaMailSender javaMailSendler;
	
	@Override
	public void sendMessage(Mail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
	message.setTo(mail.getTo());
	message.setSubject(mail.getSubject());
	message.setText(mail.getContent());
	
	javaMailSendler.send(message);
	}
}
