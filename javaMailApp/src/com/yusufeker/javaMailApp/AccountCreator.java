package com.yusufeker.javaMailApp;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;

public class AccountCreator {
    
    //String google = "https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp";
    //String microsoft = "https://signup.live.com/?lic=1";
    //String yahoo = "https://login.yahoo.com/account/create";
        
    mailApp app;
    
    Desktop desktop = null;

    public AccountCreator(mailApp app) {
        this.app = app;
    }
    
    public void createNewAccount(String type) {
        try {
            if (desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
                desktop.browse(URI.create(type));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(app, "Exception creating e-mail:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public interface Account {
        void createAccount();
    }

    public class GoogleAccount implements Account {
        @Override
        public void createAccount() {
            //app.accountCreator.createNewAccount(google);
            String google = "https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp";
            createNewAccount(google);
        }
    }

    public class MicrosoftAccount implements Account {
        @Override
        public void createAccount() {
            String microsoft = "https://signup.live.com/?lic=1";
            createNewAccount(microsoft);
        }
    }

    public class YahooAccount implements Account {
        @Override
        public void createAccount() {
            String yahoo = "https://login.yahoo.com/account/create";
            createNewAccount(yahoo);
        }
    }

    public class AccountFactory {

        //use getType method to get object of type account 
        public Account getType(String accountType) {
            if (accountType == null || accountType.isEmpty()) {
                return null;
            }
            if (accountType.equalsIgnoreCase("Google")) {
                return new GoogleAccount();

            } else if (accountType.equalsIgnoreCase("Microsoft")) {
                return new MicrosoftAccount();

            } else if (accountType.equalsIgnoreCase("Yahoo")) {
                return new YahooAccount();
            }
            return null;
        }
    }
    
    public void main(String accType) {
        AccountFactory accountFactory = new AccountFactory();
        
        Account account = accountFactory.getType(accType);
        account.createAccount();
    }
        
}
