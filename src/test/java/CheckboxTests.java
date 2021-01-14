import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class CheckboxTests extends ConfigTests{

    @BeforeMethod
    public void testSetup() {
        reportsFolder = "CheckboxFailedTests";
        baseUrl = "http://the-internet.herokuapp.com";
        open("/checkboxes");
    }

    @Test
    public void uncheckCheckedCheckboxes() {
        $$("input[type='checkbox']").stream().filter(el->el.isSelected())
                .forEach(el->el.setSelected(false));
        softAssert.fail("invoking fail");
        softAssert.assertAll();
    }

    @Test
    public void checkUncheckedCheckbox() {
        $$("input[type='checkbox']").forEach(el->{if(!el.isSelected()) el.setSelected(true);});
        softAssert.fail("invoking fail");
        softAssert.assertAll();
    }
}
