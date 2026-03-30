package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.locators.EnvConfig.EXPLICIT_TIMEOUT;

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLocator(By locator) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void checkInvisibleOfLocator(By locator) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void checkClickAndClick(By locator) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void enterNewValue(By locator, String newValue) {
        checkClickAndClick(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(newValue);
    }

}
