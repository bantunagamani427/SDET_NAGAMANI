package YT_Listeners;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {

	@Override
	public void onTestSuccess(ITestResult tr) {

System.out.println("TC case is passed");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("TC is failed");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("TC is skipped");
	}



	
	

	

	@Override
	public void onTestStart(ITestResult result) {
System.out.println("TC is started");
	}
	

}
