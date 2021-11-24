package org.igt.pompages;

import java.util.concurrent.TimeUnit;

import org.igt.drivers.DriverManager;
import org.igt.enums.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

public class espn extends BasePage {

	private final By searchbox = By.xpath("//*[@id='navbarSupportedContent']/ul[2]/div/div/div/form/input");
	private final By series_link = By.xpath("//*[@id='header-wrapper']/div[2]/nav/ul/li[3]/a/div/span");
	private final By score_box = By.xpath("//*[@id='header-wrapper']/div[3]/div/div/div/div/div/div/div[3]/div/a/div/div/div[3]/div[1]");

public espn scorebox() {
	click(score_box, WaitMethods.CLICKABLE,"Playername");
	return this;
}

public espn searchlink(String inputtext) {
	sendkeys(searchbox,inputtext,WaitMethods.PRESENCE, "PlayerName");	
	return this;
}

public espnscorecheck findseries() {
//	Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);    //Use this in place of Thread.sleep(5000)
	
	//OR
	// Use below method in place of Thead.sleep, Disabling it as of now as short method is mentioned below
	/*
	WebDriverWait  wait = new WebDriverWait(DriverManager.getDriver(),10);
	wait.until(ExpectedConditions.elementToBeClickable(series_link));  // This is java 7 way
	wait.until(d->d.findElement(series_link).isEnabled());    //This is java 8 
	*/
	
	//We can use above WebDriverWait method like below i.e. no need to create variable
	// Now this is also moved to BasePage class
	// new WebDriverWait(DriverManager.getDriver(),10).until(d->d.findElement(series_link).isEnabled());
	
	 
	 click(series_link,WaitMethods.CLICKABLE,"Playername");
	return new espnscorecheck();
}

public String getTitle() {
	return getPageTitle();
}
   
		
}
