import org.testng.annotations.Factory;

public class StudentRegFormFactory {

    @Factory
    public Object[] doRegistrationUsingFactory() {
        return new Object[] {
                new FillStudentRegForm("firstName1","lastName1","Female","1231231231"),
                new FillStudentRegForm("firstName2","lastName2","Male","4536452343"),
                new FillStudentRegForm("firstName3","lastName3","Other","2354345873")
        };
    }
}
