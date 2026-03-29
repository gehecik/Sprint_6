package org.example;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Stream;

public class OrderTest {
    @RegisterExtension
    private final DriverExtension extension = new DriverExtension();

    @ParameterizedTest
    @MethodSource("orderData")
    public void createOrderSuccessfully(List<String> personData, List<String> rentData) {
        WebDriver driver = extension.getDriver();
        var orderPage = new OrderPage(driver);

        orderPage.openPage();
        orderPage.clickOnCookieButton();
        var statusPage = orderPage.clickOnHeaderOrderButton();
        //clickOnMiddleOrderButton()

        statusPage.checkOrderContent();
        statusPage.enterOrderPerson(personData);
        var statusPage2 = statusPage.clickOnNextOrderButton();
        statusPage2.checkRentContent();
        statusPage2.enterOrderRent(rentData);
        statusPage2.clickOnLastOrderButton();
        statusPage2.clickOnYesButton();
        statusPage2.checkOrder();
        var statusPage3 = statusPage2.clickOnStatusViewButton();
        statusPage3.checkStatusContent();

    }

    private static Stream<Arguments> orderData() {
        return Stream.of(
                Arguments.of(
                        List.of("Имя",
                                "Фамилия",
                                "Тестовый адрес 123",
                                "Черкизовская",
                                "+1111111111"
                        ),
                        List.of("30-е марта 2026",
                                "пятеро суток",
                                "black",
                                "Хотела проработать календарь, но не получилось"
                        )
                ),
                Arguments.of(
                        List.of("ИмяИмя",
                                "ФамилияФамилия",
                                "Тестовый адрес 456",
                                "Преображенская площадь",
                                "+2222222222"
                        ),
                        List.of("30-е марта 2026",
                                "сутки",
                                "grey",
                                "Времени нет"
                        )
                )
        );
    }

}
