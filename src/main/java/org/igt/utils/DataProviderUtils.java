package org.igt.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.igt.frameworkconstants.FrameworkConstants;
import org.testng.annotations.DataProvider;

/**
 * Class having method to control the test case execution from excel sheet.<p>
 * No need to use enabled=false against test cases in testng annotations.
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExcelUtils
 */
public class DataProviderUtils {
	
	protected static List<Map<String,String>> list = new ArrayList<>();   //Have to make it static otherwise it will not be called inside below method
	
	/**
	 * This method will find out list of test cases<p>
	 * which from excel sheet which are applicable for test case execution
	 * @param m
	 * @return
	 */
	@DataProvider(parallel=true)
	public static Object[] getTestData(Method m) {   //This Method m is part of java reflect method which helps to identify which method is calling this method.
		
		String testcasename = m.getName();		//To get the name of the calling method
		if(list.isEmpty()) {   //We make it conditional because it will be empty only first time after that it will not be called. Without this it will open this data sheet every time which will impact performance.
			list = ExcelUtils.getTestDetails(FrameworkConstants.getTestdatasheet());
		}				
		List<Map<String,String>> iterationlist = new ArrayList<>();	//This small list will be used to put values find out from excellist which are required for run i.e. only execute "yes" will be put in this list and then this list will be returned as part of this method.
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testcasename) &&
				(list.get(i).get("execute").equalsIgnoreCase("yes"))) {
					iterationlist.add(list.get(i));
				}								
		}
	//	list.removeAll(iterationlist); // We can keep this but directly removing data from list like this is not a good coding practice as whole index position will be changed. Anyway this line is also not required.
		return iterationlist.toArray();		//As method is asking to return an array.
	}
}
