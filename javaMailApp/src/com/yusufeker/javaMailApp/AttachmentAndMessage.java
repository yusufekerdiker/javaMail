
package com.yusufeker.javaMailApp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AttachmentAndMessage {
    
    mailApp app;
    MailHosts mailHosts;

    public AttachmentAndMessage(MailHosts mailHosts) {
        this.mailHosts = mailHosts;
    }

    public AttachmentAndMessage(mailApp app) {
        this.app = app;
    }
    
    public static List<File> attachmentList = new ArrayList<File>();
    
    protected void addAttachBtn(java.awt.event.ActionEvent evt) {
        
        JFileChooser chooser = new JFileChooser();
        app.attachmentPathList.setEditable(false);
        chooser.setMultiSelectionEnabled(true);

        //JScrollPane scrollPane=new JScrollPane(path_attachment_area);
        //add(scrollPane,BorderLayout.CENTER);
        if (chooser.showOpenDialog(app) == JFileChooser.APPROVE_OPTION) {
            for (File files : chooser.getSelectedFiles()) {
                if (!files.isDirectory() && !attachmentList.contains(files)) {
                    attachmentList.add(files);
                    app.attachmentPathList.append(files.getAbsolutePath() + "\n");
                }
            }
        }

        //Component frame = null;
        //chooser.showOpenDialog(frame);
        //File file = chooser.getSelectedFile();
        //AttachmentPath = file.getAbsolutePath();
        //path_attachment.setText(AttachmentPath);
        //path_attachment_area.setText(AttachmentPath);
    }
    
    public void sendMailBtn(java.awt.event.ActionEvent evt) {   

        String FromMail = app.fromInput.getText();
        String FromPassword = app.passwordInput.getText();
        String ToMail = app.toInput.getText();
        String SubjectMail = app.subjectInput.getText();
        String ContentMail = app.messageInput.getText();
        String ProviderMail = String.valueOf(app.mailProviderChooser.getSelectedItem());

        String fullMailAddress = FromMail + ProviderMail;

        Properties properties = new Properties();
        if (ProviderMail.equals("@gmail.com")) {
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");
            
            //mailHosts.sendGmail();
            
            /*
            properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.port", "587");
            */
            
        } else if (ProviderMail.equals("@live.com") || ProviderMail.equals("@hotmail.com") || ProviderMail.equals("@outlook.com")) {
            properties.put("mail.smtp.host", "smtp.live.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.auth", "true");
            
            //mailHosts.sendHotmail();
            
            /*
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
            */  
        } else if (ProviderMail.equals("@yahoo.com")) {
            properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.auth", "true");
            
            //mailHosts.sendYahoo();
        }
        

        /*
        properties.put("mail.smtp.host", "smtp.live.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "587");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.port", "587");
        */
        Session session = Session.getInstance(properties,
            new Authenticator() {
            // override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fullMailAddress, FromPassword);
                }
            }
        );

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fullMailAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ToMail));
            message.setSubject(SubjectMail);
            //message.setText(ContentMail);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(ContentMail);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            for (File file : attachmentList) {
                MimeBodyPart part = new MimeBodyPart();
                part.attachFile(file);
                multipart.addBodyPart(part);
            }

                //messageBodyPart = new MimeBodyPart();
                //DataSource source = new FileDataSource((File) attachments);
                //messageBodyPart.setDataHandler(new DataHandler(source));
                //messageBodyPart.setFileName(attachment_name.getText());
                //multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);
                Transport.send(message);
                JOptionPane.showMessageDialog(app, "Message successfully sent", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(app, "Exception sending e-mail:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
