import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.*;

import static com.codeborne.selenide.Configuration.*;


@Listeners({ScreenShooter.class})
public class ConfigTests {

    @BeforeSuite
    public void defaultSetup() {
        reportsFolder="radioButtonAndCheckboxFailedTests";
        startMaximized = true;
        screenshots = true;
    }
}
