package com.example.pw23.Services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Async
    public void sendMail(String methodName, String objectBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("aminfury@mail.ru");
        message.setTo("aminfury@mail.ru");
        message.setSubject("Creation and update logging");
        message.setText("Method name: " + methodName + "\n" + "Entity body: " + objectBody);
        javaMailSender.send(message);
    }
}
