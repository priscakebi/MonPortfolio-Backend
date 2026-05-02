# Portfolio Backend - Contact API

Backend Spring Boot pour mon portfolio personnel.  
Il gère l’envoi des messages du formulaire de contact via email.

---

## Technologies utilisées

- Java 21
- Spring Boot 3
- Spring Web
- Spring Mail
- Maven

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