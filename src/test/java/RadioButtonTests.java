import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.reportsFolder;
import static com.codeborne.selenide.Selenide.*;

public class RadioButtonTests extends ConfigTests{

    @BeforeMethod
    public void testSetup() {
        reportsFolder = "RadioButtonFailedTests";
        baseUrl = "https://demoqa.com";
        open("/radio-button");
    }

    @Test
    public void selectYes() {
        $x("//label[text()='Yes']").click();
        softAssert.fail("invoking fail");
        softAssert.assertAll();
    }

    @Test
    public void isOptionNoAvailable() {
        softAssert.assertFalse($x("//label[text()='No']").isEnabled());
        softAssert.assertAll();
    }
}
