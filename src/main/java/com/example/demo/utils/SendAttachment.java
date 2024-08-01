package com.example.demo.utils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendAttachment {

    public static void main(String[] args) {

        String user = args[0];
        String password = args[1];
        String to = args[2];

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.naver.com");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Message alert");

            MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
            mimeBodyPart1.setText("This is message body");

            String filename = "img.png";
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(filename)));
            mimeBodyPart2.setFileName(filename);

            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(mimeBodyPart1);
            mimeMultipart.addBodyPart(mimeBodyPart2);

            message.setContent(mimeMultipart);
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
