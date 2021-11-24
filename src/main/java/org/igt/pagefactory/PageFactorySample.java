package org.igt.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class will provide methods for Page factory implementation.<p>
 * Although we will not use this in our framework and instead of this we will use POM concept.
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see org.openqa.selenium.support.PageFactory
 */
public class PageFactorySample {

	@CacheLookup
	@FindBy(xpath="//*[@id='navbarSupportedContent']/ul[2]/div/div/div/form/input")
	private  WebElement searchbox;

	private WebDriver driver;
	
	public PageFactorySample(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void pagefactorydemomethod() {

		for (int i = 0; i<10; i++) {
			searchbox.clear();
			searchbox.sendKeys("Sachin");
		}

	}

}
