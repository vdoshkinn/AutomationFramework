package com.company.ui.steps;

import com.company.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends Steps {

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        super.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void enterLogin(String login) {
        loginPage.loginInput.clear();
        loginPage.loginInput.sendKeys(login);
        loginPage.enterPasswordButton.click();
    }

    public void enterPassword(String password) {
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    public void validateLoginFieldIsDisplayed() {
        validateElementIsDisplayed(loginPage.loginInput);
    }
}
