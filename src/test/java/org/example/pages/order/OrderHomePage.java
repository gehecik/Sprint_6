package org.example.pages.order;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.locators.EnvConfig.*;

public class OrderHomePage extends BasePage {
    protected final By cookieButton = By.className(CLASS_COOKIE_BUTTON);
    protected final By orderButton = By.className("Button_Button__ra12g");
    protected final By orderMiddleButton = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']");

    public OrderHomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(BASE_URL);
    }

    public void clickOnCookieButton() {
        checkClickAndClick(cookieButton);
    }

    public OrderPersonPage clickOnOrderButton(String buttonForOrder) {
        if (buttonForOrder.equals("header")) {
            checkClickAndClick(orderButton);
        } else {
                checkClickAndClick(orderMiddleButton);
        }

        return new OrderPersonPage(driver);
    }

}
