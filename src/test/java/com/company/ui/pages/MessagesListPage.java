package com.company.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagesListPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='llc__item llc__item_correspondent']//span")
    public WebElement toValue;

    @FindBy(xpath = "//span[@class='ll-sj__normal']")
    public WebElement subjectValue;

    @FindBy(xpath = "//span[@class='ll-sp__normal']")
    public WebElement bodyValue;

    public MessagesListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
