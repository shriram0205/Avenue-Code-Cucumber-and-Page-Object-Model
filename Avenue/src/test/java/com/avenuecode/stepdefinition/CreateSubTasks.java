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

public class CreateSubTasks {
	 WebDriver driver;
	 LoginPage login;
	 HomePage home;
	 CreateTasksPage create;
	 ManageSubTasksPage manage;
	 
	@Given("^the user has logged into qa-avenuecode\\.com$")
	public void the_user_has_logged_into_qa_avenuecode_com() throws Throwable {
		login = new LoginPage(driver);
		login.navigateTo();
		home=login.loginAsUser();
	}

	@Then("^user navigates to mytasks$")
	public void user_navigates_to_mytasks() throws Throwable {
		create=home.checkForMyTasks();
	}	

	@When("^user creates a subtask for that task$")
	public void user_creates_a_subtask_for_that_task() throws Throwable {
		// To get the number of sub tasks and text of the "Manage Sub Tasks Button"
		create.getNameOfSubTaskButton();
		// To create subtask
		manage=create.manageSubTasks();
		Thread.sleep(2000);
		manage.createSubTask();	
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
