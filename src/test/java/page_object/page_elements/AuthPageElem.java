package page_object.page_elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPageElem {
    public static SelenideElement loginInput = $x("//input[@name='os_username']");
    public static SelenideElement passInput = $x("//input[@name='os_password']");
    public static SelenideElement logInButton = $x("//input[@name='login']");
    public static SelenideElement profileLogo = $x("//a[@id='header-details-user-fullname']");
}
