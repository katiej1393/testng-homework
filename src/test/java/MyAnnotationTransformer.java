import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlSuite;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class MyAnnotationTransformer implements IAnnotationTransformer, ISuiteListener, IReporter {

    //Using IAnnotationTransformer set disabled to any methods in the Class
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //this is for previous homework(used for retryMethod(), class "TryMyCustomAnnotation"
        annotation.setRetryAnalyzer(CustomRetryAnalyzer.class);

        if (annotation.getAlwaysRun()) {
            annotation.setEnabled(false);
        }
    }

    //Write your own implementation of ISuiteListener methods
    public void onStart(ISuite suite) {
        System.out.println("This method is invoked before the SuiteRunner starts.");
    }

    public void onFinish(ISuite suite) {
        System.out.println("This method is invoked after the SuiteRunner has run all the test suites.");
    }

    //Print the count of failed, skipped , success and all tests
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        //Iterate over every suite assigned for execution
        for (ISuite suite : suites) {
            String suiteName = suite.getName();
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                System.out.println(sr);
                ITestContext tc = sr.getTestContext();
                System.out.println("Number of all tests for suite '" + suiteName +
                        "' is: "+suite.getAllInvokedMethods().size());
                System.out.println("Number of Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Number of Failed tests for suite '" + suiteName +
                        "' is:" + tc.getFailedTests().getAllResults().size());
                System.out.println("Number Skipped tests for suite '" + suiteName +
                        "' is:" + tc.getSkippedTests().getAllResults().size());
            }
        }
    }
}

