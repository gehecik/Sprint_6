package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.EnvConfig.*;

public class StatusPage extends BasePage {

    protected final By orderContent = By.xpath(XPATH_ORDER_PERSON_CONTENT);
    protected final By orderName = By.cssSelector(SELECTOR_ORDER_NAME);
    protected final By orderSurname = By.cssSelector(SELECTOR_ORDER_SURNAME);
    protected final By orderAddress = By.cssSelector(SELECTOR_ORDER_ADDRESS);
    protected final By orderSubway = By.className(CLASS_ORDER_SUBWAY);
    protected final By subwayValue = By.className(CLASS_SUBWAY_VALUE);
    protected final By orderPhone = By.cssSelector(SELECTOR_ORDER_PHONE);
    protected final By orderNextButton = By.className(CLASS_NEXT_ORDER_BUTTON);

    public StatusPage(WebDriver driver) {
        super(driver);
    }

    public void checkOrderContent() {
        checkLocator(orderContent);
    }

    public void enterSubwayValue(By locator, String subway) {
        checkClickAndClick(locator);
        By locatorSubway = By.xpath("//div[text()='" + subway + "']");
        checkClickAndClick(locatorSubway);
    }

    public void enterOrderPerson(PersonData personData) {
        enterNewValue(orderName, personData.name);
        enterNewValue(orderSurname, personData.surname);
        enterNewValue(orderAddress, personData.address);
        enterSubwayValue(orderSubway, personData.subway);
        enterNewValue(orderPhone, personData.phone);
    }

    public StatusPage2 clickOnNextOrderButton() {
        checkClickAndClick(orderNextButton);

        return new StatusPage2(driver);
    }
}
