package com.company.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@data-testid='login-input']")
    public WebElement loginInput;

    @FindBy(xpath = "//button[@data-testid='enter-password']")
    public WebElement enterPasswordButton;

    @FindBy(xpath = "//input[@data-testid='password-input']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@data-testid='login-to-mail']")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
