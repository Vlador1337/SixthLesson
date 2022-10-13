package page_object.page_steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebHooks {
    @Before
    public static void setUp() {
        Configuration.startMaximized = true;
    }

    @After
    public void driverClose() {
        WebDriverRunner.closeWebDriver();
    }
}
