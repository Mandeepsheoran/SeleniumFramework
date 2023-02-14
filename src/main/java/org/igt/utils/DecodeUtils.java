package org.igt.utils;

import java.util.Base64;

/**
 * 
 * Class to provide method for decoding an encoded String like Password and other sensitive information<p>
 * Apr 25, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExcelUtils
 * @see org.igt.drivers.Driver
 */


public class DecodeUtils {
	
	private DecodeUtils() {		
	}	
	/**
	 * This will decode the encoded password passed from excel sheet.
	 * @param encodedString
	 * @return
	 * @see java.util.Base64
	 */
	public static String getDecodedString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}
	
	
	
/*	Below code is not for this class. This is just to show how to use above method in test scripts. 
 * Below is example of test method in scripts where we are calling above method. 
 * Currently don't have login specific test case hence writing it here. 
 */
	
//	public enterpassword(String password) {
//		sendKeys(textboxPassword,DecodeUtils.getDecodedString(password));
//	}

}
