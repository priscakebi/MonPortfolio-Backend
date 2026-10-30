# Portfolio Backend - Contact API

Backend Spring Boot pour mon portfolio personnel.  
Il gère l’envoi des messages du formulaire de contact via email.

---

## Technologies utilisées

- Java 17
- Spring Boot 3
- Spring Web
- API Brevo (envoi d’email en HTTPS)
- Maven

---

## Variables d’environnement

| Variable | Obligatoire | Description |
|---|---|---|
| `BREVO_API_KEY` | oui | Clé API Brevo |
| `CORS_ALLOWED_ORIGINS` | oui en prod | URL(s) du frontend, séparées par des virgules |
| `MAIL_SENDER` | non | Expéditeur vérifié dans Brevo |
| `MAIL_RECIPIENT` | non | Adresse qui reçoit les messages |

---

## Fonctionnalités

- API REST pour le formulaire de contact
- Réception des messages (nom, email, message)
- Envoi automatique d’un email
- Backend léger sans base de données

---

## Endpoint API

### Envoyer un message

**POST** `/api/contact`

---

### Body JSON

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "message": "Bonjour, je suis intéressé par votre profil."
}