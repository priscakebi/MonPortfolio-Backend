package monportfolio.backend.service;

import monportfolio.backend.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(ContactRequest request) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("tonemail@gmail.com"); // 🔥 mets TON email
        message.setSubject("Nouveau message portfolio");

        message.setText(
                "Nom: " + request.getName() + "\n" +
                "Email: " + request.getEmail() + "\n\n" +
                request.getMessage()
        );

        mailSender.send(message);
    }
}