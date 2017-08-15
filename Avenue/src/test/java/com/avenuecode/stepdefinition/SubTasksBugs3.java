package com.avenuecode.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.avenuecode.pages.CreateTasksPage;
import com.avenuecode.pages.HomePage;
import com.avenuecode.pages.LoginPage;
import com.avenuecode.pages.ManageSubTasksPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SubTasksBugs3 {
	 WebDriver driver;
	 LoginPage login;
	 HomePage home;
	 CreateTasksPage create;
	 ManageSubTasksPage manage;
	@Given("^Login and navigate to the MyTasks page$")
	public void login_and_navigate_to_the_MyTasks_page() throws Throwable {
		login = new LoginPage(driver);
		login.navigateTo();
		home=login.loginAsUser();
		create=home.checkForMyTasks();
	}

	@When("^Navigate to manage Subtasks page$")
	public void navigate_to_manage_Subtasks_page() throws Throwable {
	 manage= create.manageSubTasks();
	}

	@Then("^creation of subtasks takes place on pressing enter key instead of clicking on the Add button$")
	public void creation_of_subtasks_takes_place_on_pressing_enter_key_instead_of_clicking_on_the_Add_button() throws Throwable {
	   manage.createSubTaskOnEnterKey();
	   Boolean result=   manage.checkSubTaskNameLength();
	   System.out.println(" The list contains tasks name with length >250 characters: "+result);
	}

}
