import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//Write your own implementation of ITestListener methods
// - onTestSuccess,onTestFailure,onTestSkipped and onTestFailedButWithinSuccessPercentage
public class ITestListenerMethodsCustomImplementation  implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart() method is invoked each time before a test will be invoked.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess() method is invoked each time a test succeeds.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure() method is invoked each time a test fails.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped() method is Invoked each time a test is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Invoked each time a method fails but has been annotated with successPercentage and this " +
                "failure still keeps it within the success percentage requested.");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart() method is Invoked after the test class is instantiated and " +
                "before any configuration method is called.");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish() method is Invoked after all the tests have run and " +
                "all their Configuration methods have been called.");
    }
}
