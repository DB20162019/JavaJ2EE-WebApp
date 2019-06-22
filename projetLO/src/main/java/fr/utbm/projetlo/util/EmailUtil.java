/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.util;

/**
 *
 * @author dainahb
 */
//import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;


public class EmailUtil {
    /**
     * Utility method to send simple HTML email
     *
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(String toEmail, String subject, String body) {
        
        final String fromEmail = "inscription.courslo54@gmail.com"; //gmail address mail
        final String password = "projetecoleLO54"; // password of gmail address to send email
        
        try {

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };

            Session session = Session.getInstance(props, auth);

            MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(fromEmail, "Inscription Cours"));
            msg.setSubject(subject);
            msg.setText(body);

            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));


            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
