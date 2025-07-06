package com.ui.tests;

import com.ui.pages.HomePage;

public class LoginTest {

    public static void main(String[] args) {
        HomePage homePage = new HomePage("chrome");
        String accountName = homePage.navigateToSignInPage()
                .login("fobobe2851@axcradio.com", "Password")
                .getAccountName();
        System.out.println("Logged in successfully. Account Name: " + accountName);

    }
}
