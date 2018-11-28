import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestDice.class, TestGameLogic.class, TestLocationLuckyCard.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("****************************************************");
        System.out.println("RESULT OF ALL TESTS: " + result.wasSuccessful());
    }
}
