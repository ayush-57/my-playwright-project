package com.example;

import com.example.constants.LoginPageConstants;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    // Method to validate page redirection
    public boolean validatePageRedirectionAfterLogin() {
        page.waitForSelector(LoginPageConstants.PURCHASES_TAB_HEADING);
        return page.url().equals(LoginPageConstants.REDIRECTED_URL);
    }

    // Method to enter email
    public void enterEmail(String email) {
        page.waitForSelector(LoginPageConstants.EMAIL).click();
        page.keyboard().press("Control+A");
        page.keyboard().press("Backspace");
        page.fill(LoginPageConstants.EMAIL, email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        page.waitForSelector(LoginPageConstants.PASSWORD).click();
        page.keyboard().press("Control+A");
        page.keyboard().press("Backspace");
        page.fill(LoginPageConstants.PASSWORD, password);
    }

    // Method to click login button
    public void clickLoginButton() {
        page.click(LoginPageConstants.LOGIN_BUTTON);
    }

    // Method to get error message text
    public boolean getErrorMessage() {
        return page.waitForSelector(LoginPageConstants.INCORRECT_CREDS_TOASTER).innerText()
                .equals("Your email and/or password are incorrects");
    }

    public void logout() {
        page.waitForSelector(LoginPageConstants.HEADER_MENU).click();
        page.waitForSelector(LoginPageConstants.LOGOUT).click();
        page.waitForSelector(LoginPageConstants.EMAIL);
    }

    public boolean validateEmptyFieldsErrors() {
        return page.isVisible(LoginPageConstants.EMAIL_REQUIRED)
                && page.isVisible(LoginPageConstants.PASSWORD_REQUIRED);
    }

    public boolean validateInvalidEmailError() {
        return page.isVisible(LoginPageConstants.INVALID_EMAIL);
    }

    // Method to perform login
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    // Methods to validate password visibility toggle
    public boolean validatePasswordVisibilityToggleOff() {
        page.waitForSelector(LoginPageConstants.TOGGLE_PASSWD_VISIBILITY).click();
        return page.waitForSelector(LoginPageConstants.TOGGLE_PASSWD_VISIBILITY_SVG).getAttribute("data-testid")
                .equals("VisibilityOffIcon")
                && page.waitForSelector(LoginPageConstants.PASSWORD).getAttribute("type").equals("password");
    }

    public boolean validatePasswordVisibilityToggleOn() {
        page.waitForSelector(LoginPageConstants.TOGGLE_PASSWD_VISIBILITY).click();
        return page.waitForSelector(LoginPageConstants.TOGGLE_PASSWD_VISIBILITY_SVG).getAttribute("data-testid")
                .equals("VisibilityIcon")
                && page.waitForSelector(LoginPageConstants.PASSWORD).getAttribute("type").equals("text");
    }

    // Method to interact with shadow element
    public void visitShadowElementLink() {
        page.navigate("https://selectorshub.com/iframe-in-shadow-dom/");
        page.locator("#userName #pizza").fill("ayush testing");
        page.waitForTimeout(2000);
    }
}
