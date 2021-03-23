import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FillStudentRegForm {
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String phoneNumber;

    public FillStudentRegForm(String firstName, String lastName, String gender, String phoneNumber) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.phoneNumber=phoneNumber;
    }

    @Test
    public void fillStudentRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").sendKeys(firstName);
        $("#lastName").sendKeys(lastName);
        $x("//label[text()='"+gender+"']").click();
        $("#userNumber").sendKeys(phoneNumber);
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $x("//table//tr/td[text()='Student Name']/following-sibling::td")
                .shouldHave(text(firstName+" "+lastName));
    }
}

