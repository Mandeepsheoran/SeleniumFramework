package org.igt.seleniumframework;

import org.igt.pompages.DynamicLocators;
import org.openqa.selenium.WebDriver;

public class DynamiclocatorUsage {
	
	WebDriver driver;
	
	public void dynmaclocator() {
		DynamicLocators dynlctr = new DynamicLocators(driver);
		dynlctr.clickmenu("ActionCode");    // Here we have passed the actual dynamic locator
	}

}
