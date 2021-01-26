import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FillStudentRegFormDataProvider {
    @Test(dataProvider = "dataForRegistrationForm", dataProviderClass = DataProviderStudentRegForm.class)
    public void fillStudentRegistrationFormWithDP(String fN, String lN, String gender, String mN) {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").sendKeys(fN);
        $("#lastName").sendKeys(lN);
        $x("//label[text()='"+gender+"']").click();
        $("#userNumber").sendKeys(mN);
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $x("//table//tr/td[text()='Student Name']/following-sibling::td").shouldHave(text(fN+" "+lN));
    }
}
