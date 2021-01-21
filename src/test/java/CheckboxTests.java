import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class CheckboxTests extends ConfigTests {

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void methodSetup() {
        //baseUrl = "http://the-internet.herokuapp.com";
        open("http://the-internet.herokuapp.com/checkboxes");
    }

    @AfterMethod
    public void teardown() {
        Selenide.closeWebDriver();
    }

    @Test(groups = {"FrontEnd"})
    public void uncheckCheckedCheckboxes() {
        $$("input[type='checkbox']").stream().filter(el->el.isSelected())
                .forEach(el->el.setSelected(false));
        $$("input[type='checkbox']").forEach(el->softAssert.assertTrue(el.isSelected()));
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = {"uncheckCheckedCheckboxes"},alwaysRun = true, groups = {"BackEnd"})
    public void checkUncheckedCheckbox() {
        $$("input[type='checkbox']").forEach(el->{if(!el.isSelected()) el.setSelected(true);});
        softAssert.fail("invoking fail");
        softAssert.assertAll();
    }
}
