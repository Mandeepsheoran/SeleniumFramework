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

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>(); 

	public static WebDriver getDriver() {
		return dr.get();
	}	
	
	static void setDriver(WebDriver driverref) { 
		if(Objects.nonNull(driverref)) {
			dr.set(driverref);
		}
	}
	static void unload() {
		dr.remove();
	}
}
