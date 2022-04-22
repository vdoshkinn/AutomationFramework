package com.company.ui.utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
    public static final int timeOutInSeconds = 5;

    public static WebElement waitForElement(WebDriver driver, WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException timeoutException) {
            webElement = null;
        }
        return webElement;
    }

    public static WebElement waitForElementToBeSelected(WebDriver driver, WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.elementSelectionStateToBe(webElement, true));
        } catch (TimeoutException timeoutException) {
            webElement = null;
        }
        return webElement;
    }
}
