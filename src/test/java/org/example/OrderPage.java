package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.EnvConfig.*;

public class OrderPage extends BasePage  {
    protected final By cookieButton = By.className(CLASS_COOKIE_BUTTON);
    protected final By header = By.className(CLASS_HEADER_NAV);
    protected final By orderButton = By.className(CLASS_ORDER_BUTTON);
    protected final By orderMiddleButton = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(BASE_URL);
    }

    public void clickOnCookieButton() {
        checkClickAndClick(cookieButton);
    }

    public StatusPage clickOnOrderButton(String buttonForOrder) {
        if (buttonForOrder.equals("header")) {
            checkClickAndClick(orderButton);
        } else {
                checkClickAndClick(orderMiddleButton);
        }

        return new StatusPage(driver);
    }

}
