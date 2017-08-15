package com.avenuecode.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.avenuecode.pages.CreateTasksPage;
import com.avenuecode.pages.HomePage;
import com.avenuecode.pages.LoginPage;
import com.avenuecode.pages.ManageSubTasksPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTasksBugs2 {
	 WebDriver driver;
	 LoginPage login;
	 HomePage home;
	 CreateTasksPage create;
	 ManageSubTasksPage manage;
	@Given("^Once the user has logged in\\. navigate to the My Tasks link on the nav bar\\.$")
	public void once_the_user_has_logged_in_navigate_to_the_My_Tasks_link_on_the_nav_bar() throws Throwable {
		login = new LoginPage(driver);
		login.navigateTo();
		home=login.loginAsUser();
		create=home.checkForMyTasks();
	}

	@When("^create a task name without entering anything by clicking on the plus button\\.$")
	public void create_a_task_name_without_entering_anything_by_clicking_on_the_plus_button() throws Throwable {
	   create.createTaskWithoutName();
	}

	@Then("^Try modifying the name of the task and it throws an unexpected error\\.$")
	public void try_modifying_the_name_of_the_task_and_click_the_tick_button() throws Throwable {
	    create.getTaskWithEmptyName();
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
