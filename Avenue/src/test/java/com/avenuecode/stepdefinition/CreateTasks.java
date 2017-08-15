package com.avenuecode.stepdefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.avenuecode.pages.CreateTasksPage;
import com.avenuecode.pages.HomePage;
import com.avenuecode.pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
/*  */
public class CreateTasks {
	 WebDriver driver;
	 LoginPage login;
	 HomePage home;
	 CreateTasksPage create;
	 
	@Given("^user has logged in$")
	public void user_has_logged_in() throws Throwable {
		login = new LoginPage(driver);
		login.navigateTo();
		home=login.loginAsUser();
		
	}

	@Then("^Click on My Tasks Nav bar$")
	public void click_on_My_Tasks_Nav_bar() throws Throwable {
		create=home.checkForMyTasks();
	}

	@Then("^Enter the task name and press add$")
	public void enter_the_task_name_and_press_add() throws Throwable {
		//Get the Display Message of the logged in user
		create.getDisplayMessage();
		// creates a new task
		create.createTask();
	    
	}

	@And("^wait until the task is appended to the list$")
	public void wait_until_the_task_is_appended_to_the_list() throws Throwable {
		create.getRowCount();
		
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
