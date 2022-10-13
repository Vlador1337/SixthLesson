package page_object.page_elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestSelenium_bugPageElem {
    public static SelenideElement status = $x("//span[contains(@class, 'jira-issue-status-lozenge-max-width-medium')]");
    public static SelenideElement versionsAffected = $x("//span[@id='versions-field']");
}
