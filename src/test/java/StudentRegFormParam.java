import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegFormParam {

    @Test()
    @Parameters({"firstName","lastName","gender","mobileNumber"})
    public void fillStudentRegistrationFormWithParameters(String firstName, String lastName,
                                            String gender, String mobileNumber) {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").sendKeys(firstName);
        $("#lastName").sendKeys(lastName);
        $x("//label[text()='"+gender+"']").click();
        $("#userNumber").sendKeys(mobileNumber);
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $x("//table//tr/td[text()='Student Name']/following-sibling::td")
                .shouldHave(text(firstName+" "+lastName));
    }
}
