package org.igt.drivers;

import java.net.MalformedURLException;
import java.util.Objects;

import org.igt.enums.ConfigPropertiesEnum;
import org.igt.exceptions.BrowserInvocationException;
import org.igt.factories.DriverFactory;

import org.igt.utils.ReadPropertyFile;
import org.igt.drivers.DriverManager;


/**
 * Class to start and close browser instances and get specific environment URL
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see org.igt.frameworkconstants.FrameworkConstants
 */
public class Driver {

	private Driver() {
		
	}
	/**
	 * Method to initiate the browser driver
	 * @param browser will be picked from configuration file
	 */
	public static void initdriver(String browser, String browserversion) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser,browserversion));
			} catch (MalformedURLException e) {
			throw new BrowserInvocationException("Please check the browser capabilities. Driver initialization is having problem");
			}
			DriverManager.getDriver().get(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.URL));		
	}
	}

	/**
	 * Method to close the driver after execution completion
	 */
	public static void quitdriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
