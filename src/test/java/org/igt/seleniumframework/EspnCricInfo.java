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
	
		/*	espnlinks.findseries();
		espnlinks.scorebox();
		espnlinks.searchlink("sachin"); */

		espnlinks.scorebox().searchlink("sachin").findseries();
	}
	
	
	// (dataProvider="getPlayerName",dataProviderClass=DataProviderUtils.class,retryAnalyzer=RetryFailedTests.class)  
	@Test
	public void searchCrickerters(Map<String,String> map) {		
		espn espnlinks = new espn();
		espnlinks.searchlink(map.get("playername"));
		//ExtentManager.getExtentTest().pass("Playername is Searched");
	}

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
