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

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();  

	public static ExtentTest getExtentTest() {  
		return extTest.get();
	}	
	static void setExtentTest(ExtentTest test) { 
		if(Objects.nonNull(test)) {
			extTest.set(test);
		}
	}
	static void unload() {
		extTest.remove();
	}
}
