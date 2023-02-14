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
	
		try(FileInputStream file= new FileInputStream(FrameworkConstants.getPropertyFilePath())) {
			
			property.load(file);   
			
			for (Entry<Object, Object> entry : property.entrySet()) {   
				PROPMAP.put(String.valueOf(entry.getKey()) , String.valueOf(entry.getValue()).trim()); 
			}
			
			
		//	property.forEach((k,v) -> PROPMAP.put(String.valueOf(k),String.valueOf(v)));
			
		}  catch (IOException e) {
			e.printStackTrace();
			System.exit(0); 
		}
	}
	/**
	 * Method to read the property file by passing the property key.
	 * @author Mandeep Sheoran
	 * @param key
	 * @return 
	 */
	public static String getPropValue(ConfigPropertiesEnum key)  { 
		if (Objects.isNull(key) || Objects.isNull(PROPMAP.get(key.name().toLowerCase()))) {                 
			throw new PropertyFileUsageException("Property name" + "key" + "not found. Please check config.properties file");
		}
		return PROPMAP.get(key.name().toLowerCase());
	}

	public static String getValue(String key) { 
		String value = "";
				
		value= property.getProperty(key);
		if (Objects.isNull(value)) {                
			throw new PropertyFileUsageException("Property name" + "key" + "not found. Please check config.properties file");
		}
		return value;
	}
}
