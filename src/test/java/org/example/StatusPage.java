package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.EnvConfig.*;

public class StatusPage extends BasePage {

    protected final By orderContent = By.xpath(XPATH_ORDER_PERSON_CONTENT);
    protected final By orderName = By.cssSelector("[placeholder='* Имя']");
    protected final By orderSurname = By.cssSelector("[placeholder='* Фамилия']");
    protected final By orderAddress = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    protected final By orderSubway = By.className("select-search__value");
    protected final By subwayValue = By.className("select-search__options");
    protected final By orderPhone = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
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

    public void enterOrderPerson(String name, String surname, String address, String subway, String phone) {
        enterNewValue(orderName, name);
        enterNewValue(orderSurname, surname);
        enterNewValue(orderAddress, address);
        enterSubwayValue(orderSubway, subway);
        enterNewValue(orderPhone, phone);
    }

    public StatusPage2 clickOnNextOrderButton() {
        checkClickAndClick(orderNextButton);

        return new StatusPage2(driver);
    }
}
