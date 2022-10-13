package page_object.page_elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraHeaderPageElem {
    public static SelenideElement tasksButton = $x("//a[@id='find_link']");
    public static SelenideElement tasksSearchButton = $x("//*[@id='issues_new_search_link_lnk']");
    public static SelenideElement openTasksButton = $x("//a[@id='filter_lnk_reported_lnk']");
    public static SelenideElement searchField = $x("//input[@class='search']");
    public static SelenideElement createBugReportButton = $x("//a[@id='create_link']");
    public static SelenideElement issueType = $x("//input[@id='issuetype-field']");
    public static SelenideElement summaryInput = $x("//input[@id = 'summary']");
    public static SelenideElement version = $x("//option[@value = '10001']");
    public static SelenideElement assignOnMe = $x(" //button[contains(text(),'Назначить меня')]");
    public static SelenideElement createIssueSubmit = $x("//input[@id = 'create-issue-submit']");
    public static SelenideElement reportedByMeTasks = $x("//a[@id='filter_lnk_reported_lnk']");
    public static SelenideElement description = $x("//textarea[@id='description']");
    public static SelenideElement descriptionButton = $x("(//button[@class='aui-button' and @aria-pressed='true'])[1]");
}

