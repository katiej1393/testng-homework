import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Configuration.*;

@Listeners({ScreenShooter.class})
public class ConfigTests {

    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void defaultSetup() {
        startMaximized = true;
        screenshots = true;
    }

    @AfterMethod
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
