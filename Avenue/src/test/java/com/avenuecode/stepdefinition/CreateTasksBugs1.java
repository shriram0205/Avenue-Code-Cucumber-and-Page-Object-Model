package com.avenuecode.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.avenuecode.pages.CreateTasksPage;
import com.avenuecode.pages.HomePage;
import com.avenuecode.pages.LoginPage;
import com.avenuecode.pages.ManageSubTasksPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTasksBugs1 {
	 WebDriver driver;
	 LoginPage login;
	 HomePage home;
	 CreateTasksPage create;
	 ManageSubTasksPage manage;

@Given("^Once logged in with credentials, navigate to My Tasks link on the Nav bar\\.$")
public void once_logged_in_with_credentials_navigate_to_My_Tasks_link_on_the_Nav_bar() throws Throwable {
	login = new LoginPage(driver);
	login.navigateTo();
	home=login.loginAsUser();
	create=home.checkForMyTasks();
}

@When("^Create a task$")
public void create_a_task() throws Throwable {
    create.createTask();
}

@Then("^The task created is not of minimum three characters$")
public void the_task_created_is_not_of_minimum_three_characters() throws Throwable {
 Boolean result=   create.checkTaskNameLength();
 System.out.println(" The list contains tasks name with length < 3 and not > 250 characters: "+result);
}
}
