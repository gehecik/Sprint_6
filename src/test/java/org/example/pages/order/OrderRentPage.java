package org.example.pages.order;

import org.example.pages.BasePage;
import org.example.data.RentData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.example.locators.EnvConfig.*;

public class OrderRentPage extends BasePage {
    protected final By orderRentContent = By.xpath("//div[contains(text(),'Про аренду')]");
    protected final By orderDate = By.cssSelector("[placeholder='* Когда привезти самокат']");
    protected final By orderDropdown = By.className("Dropdown-placeholder");
    protected final By orderDropdownMenu = By.className("Dropdown-menu");
    protected final By calendar = By.className("react-datepicker");
    protected final By orderComment = By.cssSelector("[placeholder='Комментарий для курьера']");
    protected final By finishOrder = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']");
    protected final By yesButton = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Да']");
    protected final By statusViewButton = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Посмотреть статус']");
    protected final By orderSuccess = By.xpath("//div[contains(text(),'Заказ оформлен')]");

    public OrderRentPage(WebDriver driver) {
        super(driver);
    }

    public void selectDate(By locator, String date) {
        checkClickAndClick(locator);
        checkLocator(calendar);

        String xpath = "//div[contains(@aria-label, '" + date + "')]";
        By checkbox = By.xpath(xpath);
        checkLocator(checkbox);
        checkClickAndClick(checkbox);
        checkInvisibleOfLocator(calendar);
    }

    public void selectDropdown(By locator, String dropdown) {
        checkClickAndClick(locator);
        checkLocator(orderDropdownMenu);

        By orderDay = By.xpath("//div[text()='" + dropdown + "']");
        checkLocator(orderDay);
        checkClickAndClick(orderDay);

        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, dropdown));
    }

    public void checkRentContent() {
        checkLocator(orderRentContent);
    }

    public void selectCheckbox(String value) {
        By checkbox = By.cssSelector("label[for='" + value + "']");
        checkClickAndClick(checkbox);
    }

    public void enterOrderRent(RentData rentData) {
        selectDate(orderDate, rentData.date);
        selectDropdown(orderDropdown, rentData.days);
        selectCheckbox(rentData.color);
        enterNewValue(orderComment, rentData.comment);
    }

    public void clickOnLastOrderButton() {
        checkClickAndClick(finishOrder);
    }

    public void clickOnYesButton() {
        checkClickAndClick(yesButton);
    }

    public OrderViewPage clickOnStatusViewButton() {
        checkClickAndClick(statusViewButton);

        return new OrderViewPage(driver);
    }

    public void checkOrder() {
        checkLocator(orderSuccess);
    }
}
