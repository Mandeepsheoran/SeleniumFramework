package org.igt.factories;

import org.igt.drivers.DriverManager;
import org.igt.enums.WaitMethods;
import org.igt.frameworkconstants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contain methods with wait time required for GUI interations with element like click, element availablity,visibility.
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see org.igt.drivers.DriverManager
 * @see org.igt.frameworkconstants.FrameworkConstants
 */
public class ExplicitWaitFactory { 

	/**
	 * Handling of element clickable conditions, presence and visibility check
	 * @param waitmethod
	 * @param by
	 * @return DOM element
	 */
	public static WebElement performExplicitWait(WaitMethods waitmethod, By by) {
		WebElement element =null;
		if(waitmethod == WaitMethods.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitwaittime()).until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitmethod == WaitMethods.PRESENCE) {
			element =new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitwaittime()).until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitmethod == WaitMethods.VISIBLE) {
			element =new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitwaittime()).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitmethod == WaitMethods.HANDLESTALEELEXEC) {
			element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitwaittime())
			.until(d -> {
				System.out.println("Handling StaleElementRefException");
				if(!d.findElements(by).isEmpty()) {
					DriverManager.getDriver().navigate().refresh();
				    return d.findElement(by);
				} else {
					return d.findElement(by);
				}
			       });
		}
		else if(waitmethod == WaitMethods.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
