package org.igt.reports;

////This below code implementation is using Java 7 and we will not use it. Instaed of this, we will use "FarmeworkLogger" class
//This is to print logs in extent report. Althigh we are laready doing thsi through ExtentLogger class but we craeted this along with ConsoleLoggerImpl jus to make code more readble.
public class ExtentLoggerImpl implements Loggable {

	@Override
	public void log(String status, String message) {
		if(status.equalsIgnoreCase("Pass")) {
		ExtentManager.getExtentTest().pass(message);
		} else if (status.equalsIgnoreCase("Fail") ) {
		ExtentManager.getExtentTest().fail(message);
		} else if(status.equalsIgnoreCase("Skip")) {
			ExtentManager.getExtentTest().skip(message);
		}
	}

}
