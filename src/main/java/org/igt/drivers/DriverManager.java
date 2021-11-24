package org.igt.drivers;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

/**
 * Class to declare method for driver getter and setter, remove item from list
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public final class DriverManager {
	
	private DriverManager() {		
	}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();  //We hv make this private as it is not getting used from outside

	public static WebDriver getDriver() {
		return dr.get();
	}	
	//Change below method to deafult as only "Driver" class is using this which is only in this package.
	static void setDriver(WebDriver driverref) { //This method is void because we are not getting anything
		if(Objects.nonNull(driverref)) {
			dr.set(driverref);
		}
	}
	//Change below method to deafult as only "Driver" class is using this which is only in this package.
	static void unload() {
		dr.remove();
	}
}
