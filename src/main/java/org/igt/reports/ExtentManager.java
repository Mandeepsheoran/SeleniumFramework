package org.igt.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

/**
 * Implementation of Extent report methods for handling of multi threading in reports.
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see java.lang.ThreadLocal.ThreadLocal
 */
public class ExtentManager {

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();  //We hv make this private as it is not getting used from outside

	public static ExtentTest getExtentTest() {  //Changing this to public so that we can call it in test cases for adding author and other things
		return extTest.get();
	}	
	static void setExtentTest(ExtentTest test) { //This method is void because we are not getting anything
		if(Objects.nonNull(test)) {
			extTest.set(test);
		}
	}
	static void unload() {
		extTest.remove();
	}
}
