package org.igt.seleniumframework;

import org.igt.customannotations.FrameworkAnnotations;
import org.igt.enums.CategoryType;
import org.igt.pagefactory.PageFactorySample;
import org.igt.pompages.espn;
import org.igt.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PageModelAndPageFactoryTest extends BaseTest {
	WebDriver driver;
	
	@FrameworkAnnotations(author="Mandeep",category= {CategoryType.SMOKE},osinfo="Windows")  
	@Test(priority=1,enabled=true)  
	public void pageobjectmodeltest() {		
		ExtentManager.getExtentTest()
		         .assignAuthor("Mandeep").assignAuthor("Satish")
		         .assignCategory("Smoke").assignCategory("Regression");
		espn es = new espn();
		es.scorebox();
	}

	public void pagefactorytest() {		
		PageFactorySample pagefactry = new PageFactorySample(driver);
		pagefactry.pagefactorydemomethod();
	}
}
