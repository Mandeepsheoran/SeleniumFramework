package org.igt.seleniumframework;

import java.util.Map;

import org.igt.listeners.RetryFailedTests;
import org.igt.pompages.espn;
import org.igt.reports.ExtentManager;
import org.igt.utils.DataProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EspnCricInfo {

	@Test
	public void espnaccess() {

		espn espnlinks = new espn();

		//Usally we write code like below three lines where we are calling three different methods of "espn" class
		/*	espnlinks.findseries();
		espnlinks.scorebox();
		espnlinks.searchlink("sachin"); */

		//But using method chaining we can cover above three line in single line like below
		espnlinks.scorebox().searchlink("sachin").findseries();
	}
	
	// We are not using below annotations now as we have created AnnotationTransformer.class to set these things.
	// (dataProvider="getPlayerName",dataProviderClass=DataProviderUtils.class,retryAnalyzer=RetryFailedTests.class)   //We have notify here the class name which is providing data. This is annotation of testng.
	@Test
	public void searchCrickerters(Map<String,String> map) {		
		espn espnlinks = new espn();
		espnlinks.searchlink(map.get("playername"));
		//ExtentManager.getExtentTest().pass("Playername is Searched");
	}

	//Now we are removing below method which we created as a baby step to show how previously people used to pass data using data provider
	// This is old and poor way as we might have to pass 100 test data for example oman evisa apply visa case.
	// So if we pass data like this  then everytime we have to change data in code which is a hard coding case which need to be avoided.
	// So here we will use external sheet for data provider.
	/*
	@DataProvider(name="getPlayerName", parallel=true)
	public Object[] getCricketerName() {
		return new Object[][] {
			{"Sachin"},
			{"Sehwag"},
			{"Virat"}
		};
	} */

}
