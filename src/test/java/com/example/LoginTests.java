package com.example;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.example.utils.ConfigReader;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests {
    private Playwright playwright;
    private Browser browser;
    private ConfigReader configReader;
    private Page page;
    private LoginPage loginPage;
    private String loginPageUrl;
    private String email;
    private String password;

    @BeforeClass
    public void setUp() {
        configReader = new ConfigReader();
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
        page = browser.newPage();
        loginPage = new LoginPage(page);
        loginPageUrl = configReader.getProperty("login.url");
        email = configReader.getProperty("login.email");
        password = configReader.getProperty("login.password");
    }

    @Test
    public void testLoginSuccess() {
        page.navigate(loginPageUrl);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.validatePageRedirectionAfterLogin(),
                "Page URL does not match after successful login");
        loginPage.logout();
    }

    @Test
    public void testLoginFailure() {
        page.navigate(loginPageUrl);
        loginPage.login("", "");
        Assert.assertTrue(loginPage.validateEmptyFieldsErrors(), "Errors for empty inputs not displayed");
        loginPage.enterEmail("abcd");
        Assert.assertTrue(loginPage.validateInvalidEmailError(), "Error for invalid email not displayed");
        loginPage.login("ayush@testing.com", "wrongpassword");
        Assert.assertTrue(loginPage.getErrorMessage(), "Toaster message not displayed");
    }

    @Test
    public void testPasswordVisibilityToggle() {
        page.navigate(loginPageUrl);
        loginPage.enterPassword("PasswordTest");
        Assert.assertTrue(loginPage.validatePasswordVisibilityToggleOn(), "Password visibility toggle not on");
        Assert.assertTrue(loginPage.validatePasswordVisibilityToggleOff(), "Password visibility toggle not off");
    }

    @Test
    public void shadownElement() {
        loginPage.visitShadowElementLink();
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
