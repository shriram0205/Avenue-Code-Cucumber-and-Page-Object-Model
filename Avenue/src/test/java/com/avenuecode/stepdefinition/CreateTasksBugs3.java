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


public class CreateTasksBugs3 {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	CreateTasksPage create;

	@Given("^Login with the user credentials\\.$")
	public void login_with_the_user_credentials() throws Throwable {
		login = new LoginPage(driver);
		login.navigateTo();
		home=login.loginAsUser();
	}

	@Then("^Navigate to My Tasks by clicking on the My Tasks button on the top left corner of the navigation bar\\.$")
	public void navigate_to_My_Tasks_by_clicking_on_the_My_Tasks_button_on_the_top_left_corner_of_the_navigation_bar() throws Throwable {
		create=home.checkForMyTasks();
	    }

	@Then("^Click on the plus button next to the empty task name field\\.$")
	public void click_on_the_plus_button_next_to_the_empty_task_name_field() throws Throwable {
		create.createTaskWithoutName(); 
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
