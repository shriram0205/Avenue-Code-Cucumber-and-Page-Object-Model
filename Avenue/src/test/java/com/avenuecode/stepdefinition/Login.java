package com.avenuecode.stepdefinition;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.avenuecode.pages.CreateTasksPage;
import com.avenuecode.pages.HomePage;
import com.avenuecode.pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	 WebDriver driver;
	 LoginPage login;
	 HomePage home;
	 CreateTasksPage create;
	
	@Given("^the avenue code home page$")
	public void the_avenue_code_home_page() throws Throwable {
		login = new LoginPage(driver);
		login.navigateTo();
	}

	@When("^logging in as an user$")
	public void logging_in_as_an_user() throws Throwable {
		home=login.loginAsUser();
	}

	@Then("^the home page navigation is available$")
	public void the_home_page_navigation_is_available() throws Throwable {
	    create=home.checkForMyTasks();
	}
	@Before
	public void startUp() {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	 
	@After
	public void tearDown(){
	    driver.quit();
	}
	
}
