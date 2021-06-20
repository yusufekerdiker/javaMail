package com.yusufeker.javaMailApp;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;

public class CreateAccount {

    String google = "https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp";
    String microsoft = "https://signup.live.com/?lic=1";
    String yahoo = "https://login.yahoo.com/account/create";
    
    mailApp app;
    
    Desktop desktop = null;

    public CreateAccount(mailApp app) {
        this.app = app;
    }

    public void createNewGoogleAccount() {
        try {
            if (desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
                desktop.browse(URI.create(google));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(app, "Exception creating e-mail:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void createNewMicrosoftAccount() {
        try {
            if (desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
                desktop.browse(URI.create(microsoft));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(app, "Exception creating e-mail:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void createNewYahooAccount() {
        try {
            if (desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
                desktop.browse(URI.create(yahoo));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(app, "Exception creating e-mail:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //public static void main(String[] args) {
        /*Desktop desktop = null; //= Desktop.getDesktop();
        String google = "https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp";
        String deneme = google;*/
        
        /*try {
        desktop.browse(new URI(google));
        } catch (Exception e) {
        //JOptionPane.showMessageDialog(this, "Exception creating e-mail:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
        }*/
        
        /*try {
        if (desktop.isDesktopSupported()) {
        desktop = Desktop.getDesktop();
        desktop.browse(URI.create(deneme));
        }
        } catch (Exception e) {
        e.printStackTrace();
        }*/
    }
    
    /*public void way1() {
    Desktop desktop = Desktop.getDesktop();
    
    try {
    desktop.browse(new URI("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp"));
    } catch (Exception e) {
    JOptionPane.showMessageDialog(app4, "Exception creating e-mail:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }*/

 /*public void way2() {
    Runtime rt = Runtime.getRuntime();
    String url = "https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp";
    try {
    rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
    } catch (IOException ex) {
    Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
    }
    }*/
    

    /*public void way4() {
    try {
    Desktop.getDesktop().browse(new URL(google).toURI());
    } catch (Exception e) {
    e.printStackTrace();
    }
    }*/

    /*    public static boolean openWebpage(URI uri) {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
    try {
    desktop.browse(uri);
    return true;
    } catch (Exception e) {
    e.printStackTrace();
    }
    }
    return false;
    }
    
    public static boolean openWebpage(URL url) {
    try {
    return openWebpage(url.toURI());
    } catch (URISyntaxException e) {
    e.printStackTrace();
    }
    return false;
    }*/

//}
