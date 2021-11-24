package org.igt.factories;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.igt.drivers.DriverManager;
import org.igt.enums.ConfigPropertiesEnum;
import org.igt.utils.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {

	}

	public static WebDriver getDriver(String browser,String browserversion) throws MalformedURLException {
		String runmode = ReadPropertyFile.getPropValue(ConfigPropertiesEnum.RUNMODE);
		WebDriver driver= null;

		if(browser.equalsIgnoreCase("chrome")) {
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				cap.setVersion(browserversion);
				driver = new RemoteWebDriver(new URL(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.SELENIUMGRIDURL)), cap);
			} else {
				WebDriverManager.chromedriver().setup();
				//WebDriverManager.chromedriver().clearResolutionCache().setup();
				driver = new ChromeDriver(); 
				// We will use this as driver ref now as this is thread safe
			}
		} else if(browser.equalsIgnoreCase("firefox")) {			
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				driver = new RemoteWebDriver(new URL(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.SELENIUMGRIDURL)), cap);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();	
			}              
		} else if(browser.equalsIgnoreCase("ie")) {
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.IE);					
				driver = new RemoteWebDriver(new URL(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.SELENIUMGRIDURL)), cap);
			} else {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver(); 		
			}             

		}
		return driver;
	}
}
