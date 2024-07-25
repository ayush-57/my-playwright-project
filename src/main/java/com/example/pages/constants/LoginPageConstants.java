package com.example.pages.constants;

public class LoginPageConstants {

    public static final String REDIRECTED_URL = "https://demo.haroldwaste.com/purchases";

    // Login Page Locators
    public static final String EMAIL = "//input[@name='email']";
    public static final String PASSWORD = "//input[@name='password']";
    public static final String LOGIN_BUTTON = "//span[normalize-space()='Log in']/parent::button";
    public static final String TOGGLE_PASSWD_VISIBILITY = "//button[@aria-label='toggle password visibility']";
    public static final String TOGGLE_PASSWD_VISIBILITY_SVG = "//span[@class='MuiIconButton-label']//*[name()='svg']";
    public static final String EMAIL_REQUIRED = "//div[@text-type='email']/../div[normalize-space()='Required']"; 
    public static final String PASSWORD_REQUIRED = "//div[@text-type='password']/../div[normalize-space()='Required']";
    public static final String INVALID_EMAIL = "//div[@text-type='email']/../div[normalize-space()='Email not valid']"; 
    public static final String INCORRECT_CREDS_TOASTER = "//div[@data-test-id='toaster-message']"; 

    // Post Login Locators
    public static final String PURCHASES_TAB_HEADING = "//div[normalize-space()='Purchase & Opportunity list']";
    public static final String HEADER_MENU = "//div[@data-test-id='header-menu']";
    public static final String LOGOUT = "//div[normalize-space()='Log out']";
    public static final String UPDATE_PASSWORD = "//div[normalize-space()='Update password']";

    // Update Password Locators
    public static final String CURRENT_PASS_FIELD = "//input[@name='currentPassword']";
    public static final String NEW_PASS_FIELD = "//input[@name='newPassword']";
    public static final String CONFIRM_PASS_FIELD = "//input[@name='newPasswordConfirmation']";
    public static final String UPDATE_PASSWORD_BUTTON = "//span[normalize-space()='Update password']/parent::button";
    // below xpath will itself validate that the error message is shown only below the 'Confirm New Password' field
    public static final String PASSWORDS_DO_NOT_MATCH = "//input[@name='newPasswordConfirmation']/../../following-sibling::div[normalize-space()='Passwords do not match']";

    // Shadow Locator
    public static final String SHADOW_ELEMENT = "#userName #pizza";
}
