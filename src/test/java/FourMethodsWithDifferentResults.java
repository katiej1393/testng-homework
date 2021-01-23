import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ITestListenerMethodsCustomImplementation.class})
public class FourMethodsWithDifferentResults {

    @Test
    public void successResultTest() {
        System.out.println("I am your success Test <3 ");
    }

    @Test(alwaysRun = true)
    public void alwaysRunTest() {
        System.out.println("I will get setEnabled false ");
    }

    @Test
    public void failedResultTest() {
        Assert.fail("I am sorry, but you failed the test");
    }

    @Test
    public void skippedTest() {
        throw new SkipException("I am skipping this test");
    }

    int i = 0;
    @Test(successPercentage = 70,invocationCount = 10)
    public void failedWithinSuccessPercentageResultTest() {
        i++;
        if (i > 5) {
            Assert.fail("fail with i > 5");
        }
    }
}
