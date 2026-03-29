package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;

public class OrderTest {
    @RegisterExtension
    private final DriverExtension extension = new DriverExtension();

    @Test
    public void createOrderSuccessfully() {
        WebDriver driver = extension.getDriver();
        var orderPage = new OrderPage(driver);

        orderPage.openPage();
        orderPage.clickOnCookieButton();
        var statusPage = orderPage.clickOnHeaderOrderButton();
        //orderPage.clickOnFinishOrderButton();
        statusPage.checkOrderContent();
        statusPage.enterNewNameValue("Имя");
        statusPage.enterNewSurnameValue("Фамилия");
        statusPage.enterNewAddressValue("Тестовый адрес 123");
        statusPage.enterNewPhoneValue("+1111111111");


    }


}
