package com.stepdefinitions;

import com.pageobjects.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseClass {

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
	public void user_entered_the_username_as(String UserId) {
		lp.setUser(UserId);

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
