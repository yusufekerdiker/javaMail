package com.yusufeker.javaMailApp;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Placeholder {

    mailApp app;

    public Placeholder(mailApp app) {
        this.app = app;
    }

    Font font;

    protected void addTextFieldPlaceholder(JTextField textField) {
        font = textField.getFont();
        font = font.deriveFont(Font.ITALIC); // font style
        textField.setFont(font);
        textField.setForeground(Color.LIGHT_GRAY); // font color
    }

    protected void removeTextFieldPlaceholder(JTextField textField) {
        font = textField.getFont();
        font = font.deriveFont(Font.PLAIN | Font.BOLD); // font style
        textField.setFont(font);
        textField.setForeground(Color.WHITE); // font color
    }

    protected void addTextAreaPlaceholder(JTextArea textArea) {
        font = textArea.getFont();
        font = font.deriveFont(Font.ITALIC); // font style
        textArea.setFont(font);
        textArea.setForeground(Color.LIGHT_GRAY); // font color
    }

    protected void removeTextAreaPlaceholder(JTextArea textArea) {
        font = textArea.getFont();
        font = font.deriveFont(Font.PLAIN); // font style
        textArea.setFont(font);
        textArea.setForeground(Color.WHITE); // font color
    }

    protected void fromFocusGained(java.awt.event.FocusEvent evt) {
        if (app.fromInput.getText().equals("Your Mail Address")) {
            app.fromInput.setText(null);
            app.fromInput.requestFocus();
            //remove placeholder style
            removeTextFieldPlaceholder(app.fromInput);
        }
    }

    protected void passwordFocusGained(java.awt.event.FocusEvent evt) {
        if (app.passwordInput.getText().equals("Your Password")) {
            app.passwordInput.setText(null);
            app.passwordInput.requestFocus();
            // set password character to • again
            app.passwordInput.setEchoChar('\u25cf');
            // remove placeholder style
            removeTextFieldPlaceholder(app.passwordInput);
        }
    }

    protected void toFocusGained(java.awt.event.FocusEvent evt) {
        if (app.toInput.getText().equals("Reciever Mail Address")) {
            app.toInput.setText(null);
            app.toInput.requestFocus();
            // remove placeholder style
            removeTextFieldPlaceholder(app.toInput);
        }
    }

    protected void subjectFocusGained(java.awt.event.FocusEvent evt) {
        if (app.subjectInput.getText().equals("Mail Subject")) {
            app.subjectInput.setText(null);
            app.subjectInput.requestFocus();
            // remove placeholder style
            removeTextFieldPlaceholder(app.subjectInput);
        }
    }

    protected void fromFocusLost(java.awt.event.FocusEvent evt) {
        if (app.fromInput.getText().length() == 0) {
            // add placeholder style
            addTextFieldPlaceholder(app.fromInput);
            app.fromInput.setText("Your Mail Address");
        }
    }

    protected void passwordFocusLost(java.awt.event.FocusEvent evt) {
        if (app.passwordInput.getText().length() == 0) {
            // add placeholder style
            addTextFieldPlaceholder(app.passwordInput);
            app.passwordInput.setText("Your Password");
            // if focus is not on the password area set character style to normal alphabet
            app.passwordInput.setEchoChar('\u0000');
        }
    }

    protected void toFocusLost(java.awt.event.FocusEvent evt) {
        if (app.toInput.getText().length() == 0) {
            // add placeholder style
            addTextFieldPlaceholder(app.toInput);
            app.toInput.setText("Reciever Mail Address");
        }
    }

    protected void subjectFocusLost(java.awt.event.FocusEvent evt) {
        if (app.subjectInput.getText().length() == 0) {
            // add placeholder style
            addTextFieldPlaceholder(app.subjectInput);
            app.subjectInput.setText("Mail Subject");
        }
    }

    protected void formWindowGainedFocus(java.awt.event.WindowEvent evt) {
        // Resets all placeholders if focus shifts from the app.
        app.requestFocusInWindow();
    }

    protected void messageFocusGained(java.awt.event.FocusEvent evt) {
        if (app.messageInput.getText().equals("Your Message")) {
            app.messageInput.setText(null);
            app.messageInput.requestFocus();
            // remove placeholder style
            removeTextAreaPlaceholder(app.messageInput);
        }
    }

    protected void messageFocusLost(java.awt.event.FocusEvent evt) {
        if (app.messageInput.getText().length() == 0) {
            // add placeholder style
            addTextAreaPlaceholder(app.messageInput);
            app.messageInput.setText("Your Message");
        }
    }
}
