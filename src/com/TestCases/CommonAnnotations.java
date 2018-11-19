package com.TestCases;

import org.openqa.selenium.By;

import com.GenericFunctions.GenericClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class CommonAnnotations extends GenericClass {
	
	@Before
	public static void launchBrow(){
		System.out.println("Execution Started......");
		launchApplication("FF", "http://ceotelangana.nic.in/");
		driver.findElement(By.xpath("//button[@class='close']")).click();
		
	}
	
	/*@After
	public static void quitBrow(){
		driver.quit();
		
		System.out.println("TestCase completed....");	
	}*/
	
}
