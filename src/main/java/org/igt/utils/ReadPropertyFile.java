package org.igt.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import org.igt.enums.ConfigPropertiesEnum;
import org.igt.exceptions.PropertyFileUsageException;
import org.igt.frameworkconstants.FrameworkConstants;

/**
 * Provide method to read property file using different way.
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public final class ReadPropertyFile {
	
	private  ReadPropertyFile() {
		
	}
	
	private static  Properties property = new Properties();
	private static final Map<String, String> PROPMAP = new HashMap<>();
	/**
	 * Static block to load the property file and put data in map.
	 * @author Mandeep Sheoran
	 */
	static {
		//Trying with resources
		try(FileInputStream file= new FileInputStream(FrameworkConstants.getPropertyFilePath())) {
			
			property.load(file);   // Here property load will create a Hashtable which will have content of property file
			//Hashtable---Slow but thread safe....If we have to call property file one or two times then we can use hastable
			//But if required to call multiple time we will use Hashmap which is mentioned below
			
			for (Entry<Object, Object> entry : property.entrySet()) {   //Here we have created Hashmap which has all property content
				PROPMAP.put(String.valueOf(entry.getKey()) , String.valueOf(entry.getValue()).trim()); // trim() will remove leading and trailing spaces
			}
			
			//Above code in Java 8 way. COmmenting out as of now but will use it later
		//	property.forEach((k,v) -> PROPMAP.put(String.valueOf(k),String.valueOf(v)));
			
		}  catch (IOException e) {
			e.printStackTrace();
			System.exit(0); // Here (0) means we want to exit the process gracefully i.e. slowly slowly stop all the processes
		}
	}
	/**
	 * Method to read the property file by passing the property key.
	 * @author Mandeep Sheoran
	 * @param key
	 * @return 
	 */
	public static String getPropValue(ConfigPropertiesEnum key)  { //Use this method if using Hashmap in static block above
		
		if (Objects.isNull(key) || Objects.isNull(PROPMAP.get(key.name().toLowerCase()))) {                 //Thrown actual error which will help us in debugging
			throw new PropertyFileUsageException("Property name" + "key" + "not found. Please check config.properties file");
		}
		return PROPMAP.get(key.name().toLowerCase());
	}

	// Not using below method which is based on hastable as of now as we are using Hashmap 
	public static String getValue(String key) { // Use this method if using Hashtable in static block above
		String value = "";
				
		value= property.getProperty(key);
		if (Objects.isNull(value)) {                 //Thrown actual error which will help us in debugging
			throw new PropertyFileUsageException("Property name" + "key" + "not found. Please check config.properties file");
		}
		return value;
	}
}
