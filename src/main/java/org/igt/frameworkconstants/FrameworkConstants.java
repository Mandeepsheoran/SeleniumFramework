package org.igt.frameworkconstants;

import org.igt.enums.ConfigPropertiesEnum;
import org.igt.utils.ReadPropertyFile;

/**
 * Single place to manage path of files and their respetive setter and getter for entire framework
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public final class FrameworkConstants {
	
	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/drivers/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCEPATH + "/drivers/geckodriver.exe";
	private static final String IEDRIVERPATH = RESOURCEPATH + "/drivers/IEDriverServer.exe";
	private static final String PROPERTYFILEPATH = RESOURCEPATH + "/configurations/config.properties";
	private static final String EXCELPATH = RESOURCEPATH + "/Excel/testdata.xlsx";
	private static final String TESTCASESHEET = "TestMethods";
	private static final String TESTDATASHEET = "TestData";
	private static final String EXTENTREPORTFOLDERPATH =System.getProperty("user.dir") + "/ExtentTest-Output/";
	private static String extentreportfilepath="";
	
	public static String getExtentreportfilepath() {
		if(extentreportfilepath.isEmpty()) { 
			extentreportfilepath = createExtentReportPath();
		}
		return extentreportfilepath;
	}
	
	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}
	public static String getIedriverpath() {
		return IEDRIVERPATH;
	}

	public static String getTestcasesheet() {
		return TESTCASESHEET;
	}

	public static String getTestdatasheet() {
		return TESTDATASHEET;
	}
	
	private static String createExtentReportPath()  {
		if(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}
	private static final int EXPLICITWAITTIME = 10;
	
 public static int getExplicitwaittime() {
		return EXPLICITWAITTIME;
	}

public static String getPropertyFilePath() {
		return PROPERTYFILEPATH;
	}

public static String getChromeDriverPath() {
	 return CHROMEDRIVERPATH;
 }
}
