package com.RunnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = {"com.TestCases"},
		monochrome = true,
		tags = {"@Form6"}
		
		
		)
public class RunnerClass {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	

}
