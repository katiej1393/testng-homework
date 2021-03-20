import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryAnalyzer implements IRetryAnalyzer {

    int retryCounter = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {

        MyRetryAnnotation annotation = iTestResult.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(MyRetryAnnotation.class);

        if((annotation != null) && (retryCounter < annotation.value()))
        {
            retryCounter++;
            return true;
        }
        return false;
    }
}
