import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

//@Test(singleThreaded = true)
//@Listeners({ScreenShooter.class})
public class RadioButtonTests extends ConfigTests{

    SoftAssert softAssert = new SoftAssert();

//    @BeforeTest
//    public void testSetUp(){
//        reportsFolder="RadioButtonFailedTests";
//    }

    @BeforeMethod
    public void testSetup() {
        // baseUrl = "https://demoqa.com";
        open("https://demoqa.com/radio-button");
    }

    @AfterMethod
    public void teardown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void selectYes() {
        $x("//label[text()='Yes']").click();
        softAssert.fail("invoking fail");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void isOptionNoAvailable() {
        softAssert.assertFalse($x("//label[text()='No']").isEnabled());
        softAssert.assertAll();
    }
}
