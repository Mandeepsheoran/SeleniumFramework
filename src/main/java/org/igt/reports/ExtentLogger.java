package org.igt.reports;

import org.igt.drivers.DriverManager;
import org.igt.enums.ConfigPropertiesEnum;
import org.igt.utils.ReadPropertyFile;
import org.igt.utils.ScreenShotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;

/**
 * Class to contains method for extent report logger functionality.
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExtentManager
 * @see org.igt.utils.ReadPropertyFile
 */

public class ExtentLogger {
	
	/**
	 * To display test case pass log in report.
	 * @param message
	 */
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	/**
	 * To display test case fail log in report.
	 * @param message
	 */
	public static void fail(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	/**
	 * To display skipped test case logs in report.
	 * @param message
	 */
	public static void skip(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	/**
	 * To display test case pass log in report with screenshot requirement functionality.
	 * @param message
	 * @param isScreenshotNeeded
	 */
	public static void pass(String message, Boolean isScreenshotNeeded) {
		if(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")&& isScreenshotNeeded){
			ExtentManager.getExtentTest().pass(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		} else {
			pass(message);
		}
	}
	/**
	 * To display test case fail logs in report with screenshot requirement functionality.
	 * @param message
	 * @param isScreenshotNeeded
	 */
	public static void fail(String message, Boolean isScreenshotNeeded) {
		if(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")&& isScreenshotNeeded){
			ExtentManager.getExtentTest().fail(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		} else {
			fail(message);
		}
	}
	/**
	 * To display test case skip logs in report with screenshot requirement functionality.
	 * @param message
	 * @param isScreenshotNeeded
	 */
	public static void skip(String message, Boolean isScreenshotNeeded)  {
		if(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")&& isScreenshotNeeded){
			ExtentManager.getExtentTest().skip(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		} else {
			skip(message);
		}
	}
	
	

}
