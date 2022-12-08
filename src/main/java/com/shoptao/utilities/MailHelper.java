package com.shoptao.utilities;

/**
 *
 * @author nguyen293
 */
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHelper {

    public static void sendMail(String email, int maXacNhan) {

        final String username = "shoptaovip@gmail.com";
        final String password = "lpiyxlzcorgxdzbz";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("shoptaovip@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Ma xac nhan thay doi mat khau moi - ShopTao");
            String mess = "Xin chào, <br>\n"
                    + "Mã xác nhận của bạn là : <strong> "+ maXacNhan +" </strong>";

            message.setContent( mess, "text/html; charset=UTF-8");
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
