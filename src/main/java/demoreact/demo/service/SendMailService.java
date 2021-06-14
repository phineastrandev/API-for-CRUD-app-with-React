package demoreact.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * SendMailService
 *
 * Version 1.0
 *
 * Date: 06-07-2021
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 06-07-2021          Anhtp8
 */
@Service
public class SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     *
     * @param to
     * @param body
     * @param topics
     */
    public void sendEmail(String to, String body, String topics){

        System.out.println("Sending mail");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("conacmong5@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(topics);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);

    }
}
