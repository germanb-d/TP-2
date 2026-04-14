package Punto1;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class Mail implements Notificacion {
    // String mailOrigen; es mejor aca o en el metodo? Supongo q depende de cuantos mails distintos se usen en el concurso
    String username;
    String password;
    String host;
    String port;


    public Mail(String username, String password) {
        this.username = username;
        this.password = password;
        this.host = "sandbox.smtp.mailtrap.io";
        this.port = "587";
    }

    public Mail(String username, String password, String host, String port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    @Override
    public void notificar(String mailOrigen, String mailDestino, String asunto, String contenido) {

        // configure SMTP details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);


        // create the mail Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            // create a MimeMessage object
            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(mailOrigen));
            // set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailDestino));
            // set email subject field
            message.setSubject(asunto);
            // set the content of the email message
            message.setText(contenido);

            // send the email message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
