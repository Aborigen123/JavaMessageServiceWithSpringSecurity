package jms.service;

import jms.securty.mail.Mail;

public interface EmailService {
void sendMessage(Mail mail);
}
