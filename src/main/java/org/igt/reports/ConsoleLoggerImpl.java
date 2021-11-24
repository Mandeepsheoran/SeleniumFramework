package org.igt.reports;

//This below code implementation is using Java 7 and we will not use it. Instaed of this, we will use "FarmeworkLogger" class
//Class to prin logs on console, We will call this from BasePage class method liek clik method.
public class ConsoleLoggerImpl implements Loggable {

	@Override
	public void log(String status, String message) {
		System.out.println(status+ "------"+message);

	}

}
