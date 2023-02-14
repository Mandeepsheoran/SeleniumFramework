package org.igt.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.igt.customannotations.FrameworkAnnotations;
import org.igt.elk.SendResultstoELK;
import org.igt.reports.ExtentLogger;
import org.igt.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Implementation of TestNG listeners ITestListener & ISuiteListener
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see org.igt.reports.ExtentReport
 * @see org.igt.reports.ExtentLogger
 */
public class ListenersClass implements ITestListener, ISuiteListener {

/**
 * Method to indicate the start of any test case
 * Apr 27, 2021
 * @author Mandeep Sheoran
 */
	@Override
	public void onStart(ISuite suite) {		
			ExtentReport.initReports();		
	}
	
	/**
	 * Method to indicate the finish of any test case
	 * Apr 27, 2021
	 * @author Mandeep Sheoran
	 */
	@Override
	public void onFinish(ISuite arg0) {	
			ExtentReport.flushReports();			
	}
	
	/**
	 * Method to indicate the start of any test case and add author and category to display them in Extent Report.
	 * Apr 27, 2021
	 * @author Mandeep Sheoran
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTestCase(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
		ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());		
	}

	/**
	 * This will be called when test case got passed.
	 * Apr 27, 2021
	 * @author Mandeep Sheoran
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");	
		SendResultstoELK.results(result.getMethod().getDescription(), "Pass");
	}

	/**
	 * This will be called when test case got failed.
	 * Apr 27, 2021
	 * @author Mandeep Sheoran
	 */
	@Override
	public void onTestFailure(ITestResult result) {		
			ExtentLogger.fail(result.getMethod().getMethodName()+" is failed",true); 
			ExtentLogger.fail(result.getThrowable().toString());   
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));  
			SendResultstoELK.results(result.getMethod().getDescription(), "Fail");
	}

	/**
	 * This will be called when test case got skipped.
	 * Apr 27, 2021
	 * @author Mandeep Sheoran
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
		SendResultstoELK.results(result.getMethod().getDescription(), "Skip");
	}

	@Override
	public void onFinish(ITestContext arg0) {
		/*
		 * We are not using this as of now.
		 */
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		/*
		 * We are not using this as of now.
		 */
		
	}


	@Override
	public void onStart(ITestContext arg0) {
		/*
		 * We are not using this as of now.
		 */
	}

	

}
