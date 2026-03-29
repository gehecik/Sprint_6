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

        statusPage.checkOrderContent();
        statusPage.enterOrderPerson(
                "Имя",
                "Фамилия",
                "Тестовый адрес 123",
                "Черкизовская",
                "+1111111111"
        );
        var statusPage2 = statusPage.clickOnNextOrderButton();
        statusPage2.checkRentContent();
        statusPage2.enterOrderRent(
                "30-е марта 2026",
                //"сутки",
                "пятеро суток",
                "black"
        );

    }


}
