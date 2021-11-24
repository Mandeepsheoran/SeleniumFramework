package org.igt.elk;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.igt.enums.ConfigPropertiesEnum;
import org.igt.utils.ReadPropertyFile;
import org.testng.Assert;

import io.restassured.response.Response;
public class SendResultstoELK {
	public static void results(String testname, String status) {
		if(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.SENDRESULTSTOELK).equalsIgnoreCase("yes")){
		Map<String,String> map = new HashMap<>();
		map.put("testName", testname);
		map.put("status", status);
		map.put("executiontime", LocalDateTime.now().toString());

		Response response = given().header("Content-Type", "application/json")
				.log()
				.all()
				.body(map)
				.post(ReadPropertyFile.getPropValue(ConfigPropertiesEnum.ELKURL));

		Assert.assertEquals(response.statusCode(), 201);
		response.prettyPrint();
	} else {
		System.out.println("Config key to send results to ELK is off hence not sending data to ELK");
	}
	}
}
