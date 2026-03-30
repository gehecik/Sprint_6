package org.example.tests.faq;

import org.example.utils.DriverExtension;
import org.example.pages.faq.ImportantQuestionsPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;

public class ImportantQuestionsTest {
    @RegisterExtension
    private final DriverExtension extension = new DriverExtension();

    @Test
    public void openMainPage() throws Exception {
        WebDriver driver = extension.getDriver();
        var iportantQuestionsPage = new ImportantQuestionsPage(driver);

        iportantQuestionsPage.openPage();
        iportantQuestionsPage.clickOnCookieButton();
        iportantQuestionsPage.checkQuestionAnswer();
    }
}
