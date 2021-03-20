import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(groups = {"RetryGroup"})
public class TryMyCustomAnnotation {

    SoftAssert softAssert = new SoftAssert();
    int failTestCounter = 0;

//Create one test method that should fail 5 times and Use your annotation with parameter 10
    @MyRetryAnnotation(10)
    @Test(groups = {"FrontEnd"})
    public void retryMethod() {
        if(failTestCounter < 5) {
            softAssert.fail();
            failTestCounter++;
            softAssert.assertAll();
        }
    }
}
