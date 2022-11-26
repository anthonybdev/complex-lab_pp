package Lab6.Logger;
import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class Loggers {
    Logger logger = Logger.getLogger(Loggers.class);

    private String email = "--your mail--";
    private String pass = "--your password--";
    private String host = "smtp.gmail.com";
    private Session session;

    public Loggers() {
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, pass);
            }});
    }

    public void LogErorr( String messageText) {
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("--your mail--"));
            message.setSubject("Error in Trains Program");
            Date date = new Date();
            message.setText(date+"  Erorr - "+messageText);

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public void LogInfo(String massage){
        logger.info(massage);
    }

}



