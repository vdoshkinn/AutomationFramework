package com.company.ui.steps;

import com.company.ui.utils.SeleniumUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Steps {
    WebDriver driver;

    protected void validateText(String text, WebElement webElement) {
        Assert.assertEquals(text, SeleniumUtils.waitForElement(driver, webElement).getText());
    }

    protected void validateElementIsDisplayed(WebElement webElement) {
        Assert.assertNotNull(SeleniumUtils.waitForElement(driver, webElement));
    }

    protected WebElement waitForElement(WebElement webElement) {
        return SeleniumUtils.waitForElement(driver, webElement);
    }

    protected WebElement waitForElementToBeSelected(WebElement webElement) {
        return SeleniumUtils.waitForElementToBeSelected(driver, webElement);
    }
}
