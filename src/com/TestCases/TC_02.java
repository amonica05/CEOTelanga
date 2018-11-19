package com.TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericFunctions.GenericClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_02 extends GenericClass{
	
	public static String homepage = null;
	@Given("Navigate to form page")
	public static void navToForm(){
    	hoverClick(driver.findElement(By.xpath("//button[contains(text(),'PDF Electoral')]")));

		hoverClick(driver.findElement(By.xpath("//button[contains(text(),'E-Registration')]")));
    	hoverClick(driver.findElement(By.xpath("//button[contains(text(),'E-Registration')]/following-sibling::div//li/a[contains(text(),'Assembly')]")));
    	driver.findElement(By.xpath("//a[contains(text(),'Form-6')]")).click();
    	homepage = driver.getWindowHandle();
	}
	
    @When("Enter valid Credentials")
	public static void enterVal() throws InterruptedException, IOException{
    	Set<String> handle = driver.getWindowHandles();

    	Iterator iterator = handle.iterator();
    	
    	while(iterator.hasNext())
    	{
    		String currentWindID = iterator.next().toString();
    		System.out.println(currentWindID);
    		
    		if(!currentWindID.equals(homepage)){
    			
    			driver.switchTo().window(currentWindID);
	    		System.out.println(driver.getTitle());
	    		Thread.sleep(5000);
	    		Select sel = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
	    		sel.selectByVisibleText("English");
	    		
	    		driver.findElement(By.xpath("//input[@id='applicant_photo_image']")).click();
	    		Runtime.getRuntime().exec("D:\test.exe");
	    		}
    		
    		
    	}
    }
    
    @Then("Save the details")
	public static void saveData(){
			
	}
}
