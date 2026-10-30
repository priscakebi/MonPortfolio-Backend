package monportfolio.backend.service;

import lombok.extern.slf4j.Slf4j;
import monportfolio.backend.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

/**
 * Envoie les messages du formulaire via l'API HTTP de Brevo.
 * On n'utilise pas SMTP car Render (offre gratuite) bloque les ports SMTP sortants.
 */
@Slf4j
@Service
public class EmailService {

    private static final String BREVO_URL = "https://api.brevo.com/v3/smtp/email";

    private final RestClient restClient;
    private final String senderEmail;
    private final String recipientEmail;

    public EmailService(@Value("${app.mail.api-key}") String apiKey,
                        @Value("${app.mail.sender}") String senderEmail,
                        @Value("${app.mail.recipient}") String recipientEmail) {
        this.restClient = RestClient.builder()
                .baseUrl(BREVO_URL)
                .defaultHeader("api-key", apiKey)
                .build();
        this.senderEmail = senderEmail;
        this.recipientEmail = recipientEmail;
    }

    public void sendEmail(ContactRequest request) {
        String text = "Nom : " + request.getName() + "\n"
                + "Email : " + request.getEmail() + "\n\n"
                + "Message :\n" + request.getMessage();

        Map<String, Object> body = Map.of(
                "sender", Map.of("name", "Portfolio", "email", senderEmail),
                "to", List.of(Map.of("email", recipientEmail)),
                "replyTo", Map.of("name", request.getName(), "email", request.getEmail()),
                "subject", "Nouveau message du portfolio - " + request.getName(),
                "textContent", text
        );

        restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .toBodilessEntity();

        log.info("Message de contact envoyé (expéditeur : {})", request.getEmail());
    }
}
