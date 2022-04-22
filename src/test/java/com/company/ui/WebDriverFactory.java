package com.company.ui;

import com.company.ui.enums.Browser;
import com.company.ui.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static WebDriver driver;
    private static Browser browser;

    public WebDriverFactory() {
        switch (getBrowser()) {
            case "chrome":
                this.browser = Browser.CHROME;
                break;
            case "ff":
                this.browser = Browser.FF;
                break;
            default:
                browser = Browser.CHROME;
        }
        getDriver();
    }

    public String getBrowser() {
        return PropertiesUtils.getProperty("browser");
    }

    public WebDriver getDriver() {
        String driverPath = "";
        if (driver != null) {
            return driver;
        }
        switch (browser) {
            case FF:
                driverPath = WebDriverFactory.class.getClassLoader().getResource("drivers/geckodriver.exe").getPath();
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driverPath = WebDriverFactory.class.getClassLoader().getResource("drivers/chromedriver.exe").getPath();
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
                break;
            default:
                System.out.print("Incorrect browser name, please select IE or Chrome");
        }
        return driver;
    }
}
