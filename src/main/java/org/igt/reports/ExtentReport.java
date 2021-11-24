package org.igt.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.igt.enums.CategoryType;
import org.igt.frameworkconstants.FrameworkConstants;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Extent report methods to initiate and flush reports with all type of contents
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see com.aventstack.extentreports.reporter.ExtentSparkReporter
 * @see ExtentManager
 */
public class ExtentReport {

	private ExtentReport() {
	}
	public static ExtentReports extent;
	
	/** 
	 * Method to initiate the extent report by setting theme,title and report name.
	 * Apr 27, 2021
     * @author Mandeep Sheoran
	 */
	public static void initReports()  {
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath()); //This will store report on project root folder
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ExtentReport");
		spark.config().setReportName("Sample Extent Repprt");
		}
	}
	/** 
	 * Method to flush the extent report,close the thread and open the file automatically once it generates.
	 * Apr 27, 2021
     * @author Mandeep Sheoran
	 */
	public static void flushReports()  {
		if(Objects.nonNull(extent)) {
		extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfilepath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		} //This will automatically open the report with default browser once report will be generated
	}
	/** 
	 * Method to create test case in extent report.
	 * Apr 27, 2021
     * @author Mandeep Sheoran
	 */
	public static void createTestCase(String testcasename) {
		ExtentTest test = extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
	
	// If we have to pass multiple author/category name we can use array of string type for that like String[] author and iterate values using for loop 
	 //   for (String temp:author){ 
	//         ExtentManager.getExtentTest().assignAuthor(author);
	//     }
	/** 
	 * Method to add author name in report which will be passed from sheet.
	 * Apr 27, 2021
     * @author Mandeep Sheoran
	 */
	public static void addAuthors(String author) {   
		ExtentManager.getExtentTest().assignAuthor(author);
	}
	/** 
	 * Method to add category name in report which will be passed from sheet.
	 * Apr 27, 2021
     * @author Mandeep Sheoran
	 */
	public static void addCategory(CategoryType[] category) {   //We have created enum for these elemenets hence created aenum type named CategoryType[]
		for(CategoryType temp:category) {
			ExtentManager.getExtentTest().assignAuthor(temp.toString());  // We have created temp to string because this method assignAuthor accept only string
		}
	}
}
