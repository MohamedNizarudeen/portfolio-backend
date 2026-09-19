package com.example.portfolio_backend.service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class contactService {

    private final Resend resend;

    public contactService(@Value("${resend.api.key}") String apiKey) {
        this.resend = new Resend(apiKey);
    }

    public void sendContactEmail(String fromEmail, String name, String messageBody)
            throws ResendException {

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("onboarding@resend.dev")
                .to("mohamednizarudeen1003@gmail.com")
                .replyTo(fromEmail)
                .subject("New Contact from " + name)
                .html(
                        "<p><strong>Name:</strong> " + name + "</p>" +
                                "<p><strong>Email:</strong> " + fromEmail + "</p>" +
                                "<p><strong>Message:</strong></p>" +
                                "<p>" + messageBody + "</p>"
                )
                .build();

        CreateEmailResponse response = resend.emails().send(params);

        System.out.println("Email sent successfully. Resend ID: " + response.getId());
    }
}