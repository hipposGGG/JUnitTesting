package autoTest;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class DynamicTestsRunner extends Runner{

	List<String> testCases = new LinkedList<>();

	public DynamicTestsRunner(Class<?> testClass) {
		for(int i = 0; i < 20; i++) {
			testCases.add("Test-" + i);
		}
	}

	/**
	 * テストケースやテストスイートの情報(Descriptionクラス)
	 *
	 */
	@Override
	public Description getDescription() { //テストスイート
		Description desc = Description.createSuiteDescription("DynamicTests");
		for(String testCase : testCases) {
			desc.addChild(getDescription(testCase));
		}
		return desc;
	}
	public Description getDescription(String testName) { //テストケース
		return Description.createSuiteDescription("DynamicTests",testName);
	}

	@Override
	public void run(RunNotifier notifier) {
		Description desc = getDescription();
		notifier.fireTestStarted(desc);
		for(String testCase : testCases) {
			invokeTest(notifier, testCase);
		}
		notifier.fireTestFinished(desc);
	}

	private void invokeTest(RunNotifier notifier, String testCase) {
		Description desc = getDescription(testCase);
		notifier.fireTestStarted(desc); //テストStart
		try {
			// TODO 実際にテストする
			if(testCase.equals("Test-4")) fail("sorry failed.");//あえてTest-4を失敗させる
			System.out.println("Execute: " + desc);
		}catch(AssertionError e) {
			notifier.fireTestFailure(new Failure(desc, e));
		}finally {
			notifier.fireTestFinished(desc);//テストEnded
		}

	}

}
