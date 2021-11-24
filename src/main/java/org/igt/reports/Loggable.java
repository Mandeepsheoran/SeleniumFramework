package org.igt.reports;

//To control print log implementation for console log print, extent log print, log4j implementation, allure report etc.
public interface Loggable {
	
	abstract void log(String status, String message);

}
