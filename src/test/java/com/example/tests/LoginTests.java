package com.example.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.example.pages.LoginPage;
import com.example.utils.ConfigReader;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
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
        String browserType = configReader.getProperty("browser.type");

        switch (browserType.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                break;
        }
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
    public void testUpdatePassword() {
        page.navigate(loginPageUrl);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.validateUpdatePasswordPopup(password, "123123123", "1231231231"),
                "Password Do Not Match error not displayed");
    }

    @Test
    public void testLoginFailures() {
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
    public void shadowElement() {
        loginPage.validateElementInShadowRoot();
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
