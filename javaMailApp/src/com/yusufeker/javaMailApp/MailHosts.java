package com.yusufeker.javaMailApp;

import java.util.Properties;

public class MailHosts {

    mailApp app;
    AttachmentAndMessage attachmentAndMessage;

    public MailHosts(AttachmentAndMessage attachmentAndMessage) {
        this.attachmentAndMessage = attachmentAndMessage;
    }

    public MailHosts(mailApp app) {
        this.app = app;
    }

    String ProviderMail = String.valueOf(app.mailProviderChooser.getSelectedItem());

    Properties properties = new Properties();

    public void sendGmail() {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }

    public void sendHotmail() {
        properties.put("mail.smtp.host", "smtp.live.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }

    public void sendYahoo() {
        properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }

}

    /*
    public void sendMail() {

        if (ProviderMail.equals("@gmail.com")) {
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");

            
            properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.port", "587");
            
        } else if (ProviderMail.equals("@live.com") || ProviderMail.equals("@hotmail.com")) {
            properties.put("mail.smtp.host", "smtp.live.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.auth", "true");

            
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "smtp.live.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            ----------------------------------------------------
            properties.setProperty("mail.transport.protocol", "smtp");
            properties.setProperty("mail.host", "smtp.live.com");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.socketFactory.port", "587");
            properties.put("mail.smtp.socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
            properties.put("smtp.starttls.enable", "true");
            properties.put("mail.smtp.socketFactory.fallback", "false");
            properties.setProperty("mail.smtp.quitwait", "false"); 
            
        } else if (ProviderMail.equals("@yahoo.com")) {
            properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.auth", "true");
        }
    }
    */