package org.igt.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.igt.frameworkconstants.FrameworkConstants;
import org.igt.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

/**
 * Class to provide methods which will extract list of applicable test data <p>
 * from complete list of data gathered using (@link org.igt.utils.ExcelUtils).<p>
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see org.igt.utils.ExcelUtils
 */
public class MethodInterceptor implements IMethodInterceptor {

	/**
	 * This method will find methods and their details and then compare and set information from "list" <p>
	 * which has extracted data from excel sheet (@link org.igt.utils.ExcelUtils).<p>
	 * We will put that data in result array so that execution can be controlled using that excel sheet.
	 */
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getTestcasesheet());
		List<IMethodInstance> result = new ArrayList<>();
	
		//Here we are finding methods and their details and then comparing and setting information from "list" which has extracted data from excel sheet so we will put that data in result array so that execution can be controlled using that excel sheet.
		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) &&
					(list.get(j).get("Execute").equalsIgnoreCase("Y"))) {
						methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("Priority")));
						result.add(methods.get(i));
					}
				}
		}	
		return result;
	}

}
