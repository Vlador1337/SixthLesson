package page_object.page_elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TasksPageElem {
    public static SelenideElement tasksNumber = $x("//div[@class='showing']");
    public static SelenideElement needToDoStatus = $x("//span[contains(text(),'Нужно сделать')]");
    public static SelenideElement inWorkStatus = $x("//span[contains(text(),'В работе')]");
    public static SelenideElement closedStatusDropdown = $x("//span[contains(text(),'Бизнес-процесс') and @class='dropdown-text']");
    public static SelenideElement closedStatus = $x("//span[@class='trigger-label' and contains(text(),'Выполнено')]");
}
