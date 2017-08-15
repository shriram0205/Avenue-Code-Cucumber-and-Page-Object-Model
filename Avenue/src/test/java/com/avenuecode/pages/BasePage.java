package com.avenuecode.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avenuecode.constants.BasePageConstants;
// This is the base class containing the methods to navigate to the mentioned url
public class BasePage {
	  protected WebDriver driver;
		@FindBy(xpath=BasePageConstants.SIGNIN_PAGE)
	    WebElement signIn;
		@FindBy(xpath=BasePageConstants.REGISTER)
		WebElement register;
	 
	  public BasePage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver,this);
	  }
		
	  public LoginPage navigateTo() {
	    driver.navigate().to("http://qa-test.avenuecode.com");
	    Assert.assertEquals("ToDo Rails and Angular", driver.getTitle());
	    return new LoginPage(driver);
	  }
	}