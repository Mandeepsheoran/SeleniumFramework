package org.igt.pompages;

import org.igt.drivers.DriverManager;
import org.igt.enums.LogType;
import org.igt.enums.WaitMethods;
import org.igt.factories.ExplicitWaitFactory;
import org.igt.frameworkconstants.FrameworkConstants;
import org.igt.reports.ConsoleLoggerImpl;
import org.igt.reports.ExtentLogger;
import org.igt.reports.ExtentLoggerImpl;
import org.igt.reports.FrameworkLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class to maintain method for element interactions.
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see org.igt.factories.ExplicitWaitFactory
 */
public class BasePage {

	/**
	 * Method to provide button click functionality.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	protected void click(By by, WaitMethods waitmethod, String elementname) {
		ExplicitWaitFactory.performExplicitWait(waitmethod, by).click();
		try {
			ExtentLogger.pass(elementname + "is clicked",true);
			new ExtentLoggerImpl().log("pass", (elementname + "is clicked"));  //Java 7 way
			new ConsoleLoggerImpl().log("pass", (elementname+" is clicked")); //To print logs on console for jenkins
			
			FrameworkLogger.log(LogType.INFO, (elementname+ " is clicked")); // Java 8 implementation
		//	FrameworkLogger.log("PASS", (elementname+ " is clicked"));  //Similar to Info message
		//	FrameworkLogger.log("CONSOLE", (elementname+ " is clicked"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to provide enter text functionality.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	protected void sendkeys(By by, String textbox, WaitMethods waitmethod, String elementname) {
		ExplicitWaitFactory.performExplicitWait(waitmethod, by).sendKeys(textbox);
		try {
			ExtentLogger.pass(textbox +"is entered sucessfully in" +elementname,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to get page title from browser.
	 * @return
	 */
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
