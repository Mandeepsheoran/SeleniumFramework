package org.igt.listeners;

import org.igt.enums.ConfigPropertiesEnum;
import org.igt.utils.ReadPropertyFile;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This will control the retry mechanism of failed test cases.<p>
 * By default we are using only one retry on failed cases.<p>
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see org.igt.utils.ReadPropertyFile
 */
public class RetryFailedTests implements IRetryAnalyzer {
	int count =0;
	int maxretry =1;
	@Override
	public boolean retry(ITestResult result) {
		boolean run = false;
		
			if(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.FAILEDRETRYTESTS).equalsIgnoreCase("yes")) {
			 run = count< maxretry;
			count++;
			return run;
         }		
		return run;
    }
}
