package com.avenuecode.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avenuecode.constants.HomePageConstants;


public class HomePage extends BasePage {
	private WebDriver driver;
	@FindBy(xpath=HomePageConstants.MYTASKS)
    WebElement myTasks;
	public HomePage(WebDriver driver) {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);	
	}
	// method to click on My Tasks link on the Home Page
public CreateTasksPage checkForMyTasks() throws InterruptedException {
		//Thread.sleep(2000);
		myTasks.click();
	   
	    return new CreateTasksPage(driver);
	  }
}
