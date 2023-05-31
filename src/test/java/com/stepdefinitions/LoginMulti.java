package com.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pageobjects.LoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginMulti extends BaseClass {

	@Before
	public static void setup() throws IOException {
		logger = Logger.getLogger("DemoGuru");
		PropertyConfigurator.configure("log4j.properties");

		// Load properties file
		try {
			configProp = new Properties();
		} catch (Exception e) {
			System.out.println(e);
		}
		FileInputStream configPropfile = new FileInputStream("Configuration.properties");
		configProp.load(configPropfile);

		String br = configProp.getProperty("browser"); // getting the browser name from config.properties file

		// Launching browser
		if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@Given("User launch the application in browser")
	public void user_launch_the_application_in_browser() {
		lp = new LoginPage(driver);
	}

	@When("User opens the url as {string}")
	public void user_opens_the_url_as(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	@And("User entered the username as {string}")
	public void user_entered_the_username_as(String User) {
		lp.setUser(User);

	}

	@And("User entered the password as {string}")
	public void user_entered_the_password_as(String password) {
		lp.setPassword(password);
	}

	@And("User clicked on Login button")
	public void user_clicked_on_login_button() {
		lp.setLogin();

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if (title.equals("GTPL Bank Manager HomePage")) {
			System.out.println("Home page entered successfully");
		} else {
			System.out.println("Login Failed");
		}

	}

	@And("close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
