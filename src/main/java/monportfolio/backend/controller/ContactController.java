package monportfolio.backend.controller;

import monportfolio.backend.dto.ContactRequest;
import monportfolio.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String sendMessage(@RequestBody ContactRequest request) {
        emailService.sendEmail(request);
        return "Message envoyé";
    }
}