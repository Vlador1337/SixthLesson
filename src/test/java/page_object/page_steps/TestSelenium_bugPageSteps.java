package page_object.page_steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static page_object.page_elements.TestSelenium_bugPageElem.status;
import static page_object.page_elements.TestSelenium_bugPageElem.versionsAffected;

public class TestSelenium_bugPageSteps {
    @Then("Проверить статус задачи TestSelenium_bug")
    public static void checkStatusTask() {
        String statusTask = status.shouldBe(Condition.visible).text();
        Assertions.assertEquals("СДЕЛАТЬ", statusTask);
    }

    @Then("Проверяем версию в задаче TestSelenium_bug")
    public static void checkVersionsAffected() {
        String versionTask = versionsAffected.shouldBe(Condition.visible).text();
        Assertions.assertEquals("Version 2.0", versionTask);
    }
}
