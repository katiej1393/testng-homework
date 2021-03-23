import org.testng.annotations.DataProvider;

public class DataProviderStudentRegForm {

    @DataProvider(name = "dataForRegistrationForm")
    public static Object[][] createData() {
        return new Object[][] { {"firstName1","lastName1","Female","1111111111"},
                                {"firstName2","lastName2","Male","22222222222"},
                                {"firstName3","lastName3","Other","33333333333"},
        };
    }
}

