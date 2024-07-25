package com.example.constants;

public class LoginPageConstants {

    public static final String LOGIN_URL = "https://demo.haroldwaste.com/";
    public static final String REDIRECTED_URL = "https://demo.haroldwaste.com/purchases";
    public static final String EMAIL = "//input[@name='email']";
    public static final String PASSWORD = "//input[@name='password']";
    public static final String LOGIN_BUTTON = "//span[normalize-space()='Log in']/parent::button";
    public static final String TOGGLE_PASSWD_VISIBILITY = "//button[@aria-label='toggle password visibility']";
    public static final String TOGGLE_PASSWD_VISIBILITY_SVG = "//span[@class='MuiIconButton-label']//*[name()='svg']";
    public static final String EMAIL_REQUIRED = "//div[@text-type='email']/../div[normalize-space()='Required']"; 
    public static final String PASSWORD_REQUIRED = "//div[@text-type='password']/../div[normalize-space()='Required']";
    public static final String INVALID_EMAIL = "//div[@text-type='email']/../div[normalize-space()='Email not valid']"; 
    public static final String INCORRECT_CREDS_TOASTER = "//div[@data-test-id='toaster-message']"; 

    public static final String PURCHASES_TAB_HEADING = "//div[normalize-space()='Purchase & Opportunity list']";
    public static final String HEADER_MENU = "//div[@data-test-id='header-menu']";
    public static final String LOGOUT = "//div[normalize-space()='Log out']";
}
