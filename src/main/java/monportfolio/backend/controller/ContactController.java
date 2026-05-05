package monportfolio.backend.controller;

import monportfolio.backend.dto.ContactRequest;
import monportfolio.backend.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
public ResponseEntity<String> sendMessage(@RequestBody ContactRequest request) {
    try {
        emailService.sendEmail(request);
        return ResponseEntity.ok("OK");
    } catch (Exception e) {
        e.printStackTrace(); // 🔥 IMPORTANT
        return ResponseEntity.status(500).body(e.getMessage());
    }
}
}