package com.company.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateEmailPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@data-type='to']//input")
    public WebElement toInput;

    @FindBy(xpath = "//input[@name='Subject']")
    public WebElement subjectInput;

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement bodyInput;

    @FindBy(xpath = "//span[text() ='Сохранить']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text() ='Отправить']")
    public WebElement sendButton;

    @FindBy(xpath = "//a[text() ='Письмо отправлено']")
    public WebElement sendConfirmationMessage;

    @FindBy(xpath = "//*[contains(text(),'Сохранено в черновиках')]")
    public WebElement savedMessage;

    @FindBy(xpath = "//button[@title='Закрыть']")
    public WebElement closeCreatePageButton;

    @FindBy(xpath = "//span[@title='Закрыть']")
    public WebElement closeConfirmationButton;

    public CreateEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
