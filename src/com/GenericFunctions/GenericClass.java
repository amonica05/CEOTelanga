package com.GenericFunctions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RunnerClass.RunnerClass;

public class GenericClass extends RunnerClass{
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	//Launch Application by providing browser and URL
	public static boolean launchApplication(String browser, String URL){
		
		boolean status = true;
		switch (browser.toLowerCase()) {
		case "ff": 	driver = new FirefoxDriver();
					driver.get(URL);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;

		}
		return false;
	}
		
	//To verify if links are active
	public static boolean httpConn(String linkURL){
			
			boolean status = true;
			try{
	    		URL url = new URL(linkURL);

				HttpURLConnection con = (HttpURLConnection)url.openConnection();
	    		con.connect();
	    		
	    		if(con.getResponseCode()==200){
	    			System.out.println("Link is active");
	    		}
	    		else{
	    			System.out.println("Link is not active");
	    		}
	
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				return false;
			}
			return status;
		}

	//To click on button/links
	public static boolean hoverClick(WebElement element){
		boolean status = true;
		try{
    		Actions act = new Actions(driver);
    		act.moveToElement(element).build().perform();
    		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			status = false;
		}
		return status;
	}
	
	//To enter values in textboxes
	public static boolean txtField(String xpath, String value){
		boolean status = true;
		try{
    		driver.findElement(By.xpath(xpath)).sendKeys(value);   		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			status = false;
		}
		return status;
	}
}
