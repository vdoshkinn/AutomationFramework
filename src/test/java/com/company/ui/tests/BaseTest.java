package com.company.ui.tests;

import com.company.ui.WebDriverFactory;

import com.company.ui.utils.PropertiesUtils;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriverFactory webDriverFactory = new WebDriverFactory();
    WebDriver driver = webDriverFactory.getDriver();

    void openMainPage() throws InterruptedException {
        driver.get(PropertiesUtils.getProperty("mainURI"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        TimeUnit.SECONDS.sleep(1);
    }

    public void closeDriver() {
        driver.manage().deleteAllCookies();
    }

    public void quitDriver() {
        driver.close();
    }
}
