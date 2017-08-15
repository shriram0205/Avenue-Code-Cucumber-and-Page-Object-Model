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

public class SubTaskBugs1 {
	 WebDriver driver;
	 LoginPage login;
	 HomePage home;
	 CreateTasksPage create;
	 ManageSubTasksPage manage;
	
	@Given("^After Navigating to the manage sub tasks section$")
	public void after_Navigating_to_the_manage_sub_tasks_section() throws Throwable {
		login = new LoginPage(driver);
		login.navigateTo();
		home=login.loginAsUser();
		create=home.checkForMyTasks();
	   
	}

	@Then("^create a sub task without entering the sub task description and due date$")
	public void create_a_sub_task_without_entering_the_sub_task_description_and_due_date() throws Throwable {
		manage=create.manageSubTasks();
		Thread.sleep(2000);
	    
	}

	@When("^An empty sub task is created\\. As per the requirements sub task name is mandatory$")
	public void an_empty_sub_task_is_created_As_per_the_requirements_sub_task_name_is_mandatory() throws Throwable {
	    manage.createSubTaskWithoutMandatoryFields();
	   Boolean checkMandatoryField= manage.checkMandatoryFields();
	   System.out.println("The mandatory fiels are empty"+checkMandatoryField);
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
