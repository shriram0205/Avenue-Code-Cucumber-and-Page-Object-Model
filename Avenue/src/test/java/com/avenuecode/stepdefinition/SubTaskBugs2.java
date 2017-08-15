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

public class SubTaskBugs2 {
	 WebDriver driver;
	 LoginPage login;
	 HomePage home;
	 CreateTasksPage create;
	 ManageSubTasksPage manage;
	@Given("^click on the myTasks page link\\.$")
	public void click_on_the_myTasks_page_link() throws Throwable {
		login = new LoginPage(driver);
		login.navigateTo();
		home=login.loginAsUser();
		create=home.checkForMyTasks();
	}

	@When("^Navigate to the manage sub tasks page for a task$")
	public void navigate_to_the_manage_sub_tasks_page_for_a_task() throws Throwable {
		manage=create.manageSubTasks();
		Thread.sleep(2000);
	}

	@Then("^check if the name of the task displayed on manage sub task page is read only$")
	public void check_if_the_name_of_the_task_displayed_on_manage_sub_task_page_is_read_only() throws Throwable {
	Boolean checkifEnabled=	manage.checkifReadOnly();
	System.out.println("The edit field is enabled:" + checkifEnabled);
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
