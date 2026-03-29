package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private WebDriver driver;

    public void startUp() {
        if ("firefox".equals(System.getProperty("browser"))) {
            startUpFirefox();

        } else {
            startUpChrome();
        }
    }

    public void startUpChrome() {
        WebDriverManager.chromiumdriver().browserVersion("146").setup();
        //WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
    }

    public void startUpFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
