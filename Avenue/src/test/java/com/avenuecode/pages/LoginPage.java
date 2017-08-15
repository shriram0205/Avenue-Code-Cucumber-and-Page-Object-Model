package com.avenuecode.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avenuecode.constants.LoginPageConstants;


public class LoginPage extends BasePage {
	protected	WebDriver driver;
	@FindBy(xpath=LoginPageConstants.SIGNIN_PAGE)
    WebElement page_sign;
	@FindBy(id=LoginPageConstants.USERNAME)
    WebElement username;
	@FindBy(id=LoginPageConstants.EMAIL)
    WebElement email;
	@FindBy(id=LoginPageConstants.PASSWORD)
    WebElement password;
	@FindBy(id=LoginPageConstants.PASSWORD_CONFIRMATION)
    WebElement password_confirmation;
	@FindBy(xpath=LoginPageConstants.SUBMIT)
    WebElement submit;

	 public LoginPage(WebDriver driver) {
		    super(driver);
		    this.driver=driver;
		    PageFactory.initElements(driver,this);
		  }
	 
	 // method to login in with the specified credentials.
	 public HomePage loginAsUser() {
		    
		    page_sign.click();
		    email.sendKeys("shriram0205@gmail.com");
		    password.sendKeys("test1234");
		    submit.click();
		    return new HomePage(driver);
		  }

}
