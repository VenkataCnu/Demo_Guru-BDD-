package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
	(
		features = "./Features\\Login.feature", 
		dryRun = false, 
		monochrome = true, 
		glue = "com.stepdefinitions//Login", 
		plugin = {"pretty", "html:test-output" }
	)

public class TestRunner {

}
