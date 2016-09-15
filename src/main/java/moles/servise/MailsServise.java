package moles.servise;

import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * Created by moles on 26.07.2016.
 */
@Service
public class MailsServise {

    @Value("${mail.username:null}")
    private  String username;
    @Value("${mail.password:null}")
    private  String password;
    @Value("${mail.mail:null}")
    private  String fromMail;
    @Value("${mail.auth:null}")
    private String smtpAuth;
    @Value("${mail.host:null}")
    private String host;
    @Value("${mail.port:null}")
    private String port;

    @Autowired
    private ApplicationResourceServise applicationResourceServise;

    public void sendMailToRestartPassword(String toMailAdress, Map model) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", smtpAuth);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toMailAdress));
           message.setSubject("GS restart password");
            String tmp= applicationResourceServise.loadingTextResource("templates/mail.ftl");
            StringReader stringReader=new StringReader(tmp);
            Template template=new Template("name",stringReader,null);
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

           message.setContent(text, "text/html; charset=utf-8" );
            Transport.send(message);
            System.out.print("Wysłano: "+toMailAdress);
        } catch (Exception e) {
            System.out.print("ERROR MAIL"+e.getMessage());
        }
    }
}
