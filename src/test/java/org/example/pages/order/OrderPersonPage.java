package org.example.pages.order;

import org.example.pages.BasePage;
import org.example.data.PersonData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPersonPage extends BasePage {

    protected final By orderContent = By.xpath("//div[contains(text(),'Для кого самокат')]");
    protected final By orderName = By.cssSelector("[placeholder='* Имя']");
    protected final By orderSurname = By.cssSelector("[placeholder='* Фамилия']");
    protected final By orderAddress = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    protected final By orderSubway = By.className("select-search__value");
    protected final By subwayValue = By.className("select-search__options");
    protected final By orderPhone = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    protected final By orderNextButton = By.className("Button_Middle__1CSJM");

    public OrderPersonPage(WebDriver driver) {
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

    public OrderRentPage clickOnNextOrderButton() {
        checkClickAndClick(orderNextButton);

        return new OrderRentPage(driver);
    }
}
