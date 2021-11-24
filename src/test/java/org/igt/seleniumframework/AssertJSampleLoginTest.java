package org.igt.seleniumframework;


import static org.assertj.core.api.Assertions.doesNotHave;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.startsWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.igt.drivers.DriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.util.Arrays;



public class AssertJSampleLoginTest extends BaseTest{
	
	//Simple test with TestNG assertions
	@Test	
	public void logintest() {     
	
	DriverManager.getDriver().findElement(By.id("//*[@id='header-wrapper']/div[3]/div/div/div/div/div/div/div[1]/div/a/div/div")).click();
	String title= DriverManager.getDriver().getTitle();
	Assert.assertTrue(Objects.nonNull(title), "Title not found");
	Assert.assertTrue(title.toLowerCase().contains("espn"));
	Assert.assertTrue(title.toLowerCase().matches("w.*" + "espn"));   //regex
	Assert.assertTrue(title.length()<10);
	Assert.assertTrue(title.length()>100);	
	}
	
	//Simple test with AssertJ assertions on data tyoe string cases
		@Test	
		public void assertjstringtest() {  
			String name= "Mandeep";
			Assertions.assertThat(name)
			    .as("This value is blank").isNotBlank()
			    .isNotEmpty()
			    .isNotNull()
			    .as("The size is not as specified").hasSize(7)
			    .contains("Man")
			    .containsPattern("\\w." + "Man")
			    .endsWith("eep")
			    .isEqualTo("Mandeep")
			    .doesNotStartWith("S");
		
		}
		
		//Simple test with AssertJ assertions on list cases
				@Test	
				public void assertjlisttest() {  
					List<String> list1 = new ArrayList<>();
					list1.add("Mandeep");
					list1.add("India");
					list1.add("Testing");
					
					Assertions.assertThat(list1)
					    .isNotEmpty()
					    .isNotNull()
					    .contains("India")
					    .containsOnlyOnce("Mandeep")
					    .startsWith("Man")
					    .containsAnyOf("Testing")
					    .doesNotContain("Sachin")
					    .isSorted();
					  
				}
				
				//Simple test with AssertJ soft assertions
				// In case of using soft assertions this will not stop test case once it got failed and will continue to execute
				@Test	
				public void assertjsoftassertn() {  					
					SoftAssertions softa = new SoftAssertions();					
					String name= "Mandeep";
					
					softa.assertThat(name)
					   .isNotBlank()
					   .isNotEmpty()
					   .isEqualTo("Sachin");
					
					System.out.println("Soft assertion working fine for AssertJ");
					
					softa.assertAll();
				}

}
