package org.igt.dataprovider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class to get data from excel sheet.
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public class DataProviderWithJson {
	@Test(dataProvider ="getJsonData")
	public void testDataFromJson(Map<String,Object> map) {	
	map.forEach((k,v)->System.out.println(k+":"+v));      
	}
	
	/**
	 * 
	 * @return the json file data which will be used to pass in test cases
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@DataProvider
	public Object[] getJsonData() throws IOException {
		HashMap<String,Object> map1 = new ObjectMapper().readValue(new File(System.getProperty("user.dir") +"/JSON/jsondata1.json"),
				new TypeReference<HashMap<String, Object>>() {});	
		return new Object[] {map1};
		
	}

}
