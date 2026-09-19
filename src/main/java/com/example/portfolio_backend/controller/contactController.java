package com.example.portfolio_backend.controller;

import com.example.portfolio_backend.entity.contactEntity;
import com.example.portfolio_backend.service.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class contactController {
    @Autowired
    private contactService contactService;

    @PostMapping
    public String contactMe(@RequestBody contactEntity form) {
        contactService.sendContactEmail(form.getEmail(), form.getName(), form.getMessage());
        return "Message sent successfully!";
    }
}
