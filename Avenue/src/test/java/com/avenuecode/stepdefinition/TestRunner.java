package com.avenuecode.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/SubTasksEnterKeyBug.feature"},
       plugin = {"pretty", "html:target/cucumber-html-report"})
public class TestRunner {
	

}
