package com.TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.GenericFunctions.GenericClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_01 extends GenericClass{
	
	@Given("Verify URL launched")
	public static void verPage(){
		String expTitle = "Welcome to the Official Website of the Chief Electoral Officer, Telangana";
		String actTitle = driver.getTitle();
		if(expTitle.trim().equals(actTitle))
		{
			System.out.println("Launched Successfully");
		}
		else
		{
			System.out.println("Application Launch is unsuccessfull");
		}
	}
	
    @When("launched verify the Tabs")
	public static void verTabs() throws IOException{
    	
    	List<WebElement> tabList = driver.findElements(By.xpath("//div[@class='navbar']/a"));
    	int tabListCount = tabList.size();
    	
    	for(int i=0; i<tabListCount; i++){
    		System.out.println(tabList.get(i).getText());
    		
    		String link = tabList.get(i).getAttribute("href");
    		System.out.println(link);
    		httpConn(link);
    	}
    	
	}
	
    @Then("click on PDF Electoral Rolls")
    public static void pdfElec(){
    	
    	/*driver.findElement(By.linkText("PDF Electoral")).click();
    	System.out.println(driver.findElement(By.linkText("PDF Electoral")).getText());*/
    	hoverClick(driver.findElement(By.xpath("//button[contains(text(),'PDF Electoral')]")));
    	
    	hoverClick(driver.findElement(By.xpath("//button[contains(text(),'E-Registration')]")));
    	hoverClick(driver.findElement(By.xpath("//button[contains(text(),'E-Registration')]/following-sibling::div//li/a[contains(text(),'Assembly')]")));
	}

}
