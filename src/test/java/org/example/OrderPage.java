package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.EnvConfig.*;

public class OrderPage {
    protected final By cookieButton = By.className(CLASS_COOKIE_BUTTON);
    protected final By header = By.className(CLASS_HEADER_NAV);
    protected final By orderButton = By.className(CLASS_ORDER_BUTTON);

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(BASE_URL);
    }

    public void clickOnCookieButton() {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(cookieButton))
                .click();
    }

    public WebElement getHeaderOrderButton() {
        return driver.findElement(header).findElement(orderButton);
    }

    public StatusPage clickOnHeaderOrderButton() {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(getHeaderOrderButton()))
                .click();

        return new StatusPage(driver);
    }

}
