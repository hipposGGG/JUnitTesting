package autoTest;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class DynamicTestsRunner extends Runner{

	public DynamicTestsRunner(Class<?> testClass) {

	}

	/**
	 * テストケースやテストスイートの情報(Descriptionクラス)
	 *
	 */
	@Override
	public Description getDescription() { //テストスイート
		Description desc = Description.createSuiteDescription("DynamicTests");
		desc.addChild(getDescription("Test-1"));
		desc.addChild(getDescription("Test-2"));
		desc.addChild(getDescription("Test-3"));
		return desc;
	}
	public Description getDescription(String testName) { //テストケース
		return Description.createSuiteDescription("DynamicTests",testName);
	}

	@Override
	public void run(RunNotifier notifier) {
		Description desc = getDescription();
		notifier.fireTestStarted(desc);
		invokeTest(notifier, "Test-1");
		invokeTest(notifier, "Test-2");
		invokeTest(notifier, "Test-3");
		notifier.fireTestFinished(desc);
	}

	private void invokeTest(RunNotifier notifier, String testCase) {
		Description desc = getDescription(testCase);
		notifier.fireTestStarted(desc); //テストStart
		try {
			// TODO 実際にテストする
			System.out.println("Execute: " + desc);
		}catch(AssertionError e) {
			notifier.fireTestFailure(new Failure(desc, e));
		}finally {
			notifier.fireTestFinished(desc);//テストEnded
		}

	}

}
