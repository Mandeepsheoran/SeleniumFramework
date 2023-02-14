package org.igt.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.igt.drivers.DriverManager;

/**
 * Implementation of dynamic locator on one sample application
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see org.igt.drivers.DriverManager
 */
public class DynamicLocators {
	
	private WebDriver driver;
	
	public DynamicLocators(WebDriver driver) {
		
	}
/*
	private final By actioncode = By.xpath("//*[@id='ActionCode']/ul[2]/div/div/div/form/input"); 
	private final By reasoncode = By.xpath("//*[@id='ReasonCode']/ul[2]/div/div/div/form/input");
	*/
	
	
	private String menuitems = ("//*[@id='%value%']/ul[2]/div/div/div/form/input");
	
	public void clickmenu(String value) {
		DriverManager.getDriver().findElement(By.xpath(menuitems.replace("%value%" , value)));   by method which is calling this
	}
	
}
