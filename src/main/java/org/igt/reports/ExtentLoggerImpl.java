package org.igt.reports;

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
