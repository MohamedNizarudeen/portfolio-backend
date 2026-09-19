package com.example.portfolio_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class contactService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(String fromEmail, String name, String messageBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("mailtonizar23@gmail.com");
        message.setReplyTo(fromEmail);
        message.setSubject("New Contact from " + name);
        message.setText("Sender: " + fromEmail + "\n\nMessage:\n" + messageBody);
        mailSender.send(message);
    }
}
