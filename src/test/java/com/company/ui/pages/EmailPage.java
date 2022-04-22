package com.company.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Написать письмо']")
    public WebElement writeNewEmail;

    @FindBy(xpath = "//div[text() ='Черновики']")
    public WebElement draftsButton;

    @FindBy(xpath = "//div[text() ='Отправленные']")
    public WebElement sentMessagesButton;

    @FindBy(xpath = "//div[@data-testid ='whiteline-account']")
    public WebElement accountButton;

    @FindBy(xpath = "//div[text() ='Выйти']")
    public WebElement logout;

    public EmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
