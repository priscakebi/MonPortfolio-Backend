package monportfolio.backend.service;

import lombok.RequiredArgsConstructor;
import monportfolio.backend.dto.ContactRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(ContactRequest request) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("priscakebi00@gmail.com"); // 
        message.setSubject("Nouveau message du portfolio");

        message.setText(
                "Nom: " + request.getName() + "\n" +
                "Email: " + request.getEmail() + "\n\n" +
                "Message:\n" + request.getMessage()
        );

        mailSender.send(message);
    }
}