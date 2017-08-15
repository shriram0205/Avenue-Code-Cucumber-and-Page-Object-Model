package com.avenuecode.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonStepDef {
	protected WebDriver driver = null;
	@Before
	public void setup(){
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://qa-test.avenuecode.com");
	}
	@After
	public void teardown(){
		driver.quit();
	}

}
