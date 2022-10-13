package page_object.page_steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import page_object.page_elements.JiraHeaderPageElem;

import static com.codeborne.selenide.Condition.visible;

public class JiraHeaderPageSteps {
    @Given("Пользователь открыл проект")
    public static void openTestProject() {
        JiraHeaderPageElem.tasksButton.click();
        JiraHeaderPageElem.tasksSearchButton.shouldBe(Condition.visible).click();
    }

    @When("Пользователь ищет задачу {string}")
    public static void searchTask(String task) {
        JiraHeaderPageElem.searchField.sendKeys(task + Keys.ENTER);
    }

    @Given("Пользователь открыл окно создания задачи и заполнил необходимые поля")
    public static void createTask() {
        JiraHeaderPageElem.createBugReportButton.shouldBe(visible).click();
        JiraHeaderPageElem.issueType.shouldBe(visible).click();
        JiraHeaderPageElem.issueType.sendKeys("Ошибка" + Keys.ENTER);
        JiraHeaderPageElem.summaryInput.shouldBe(visible).click();
        JiraHeaderPageElem.summaryInput.setValue("Тест");
        JiraHeaderPageElem.descriptionButton.shouldBe(visible).click();
        JiraHeaderPageElem.description.setValue("Описание");
        JiraHeaderPageElem.version.click();
        JiraHeaderPageElem.assignOnMe.click();
        JiraHeaderPageElem.createIssueSubmit.shouldBe(visible).click();
        JiraHeaderPageElem.tasksButton.shouldBe(visible).click();
        JiraHeaderPageElem.reportedByMeTasks.shouldBe(visible).click();
    }
}
