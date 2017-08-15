package com.avenuecode.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avenuecode.constants.ManageSubTasksConstants;



public class ManageSubTasksPage extends BasePage {
	private WebDriver driver;
	@FindBy(xpath=ManageSubTasksConstants.EDITTASK)
    WebElement editTask;
	@FindBy(xpath=ManageSubTasksConstants.NEWSUBTASK)
    WebElement newSubTask;
	@FindBy(id=ManageSubTasksConstants.DUEDATE)
    WebElement dueDate;
	@FindBy(id=ManageSubTasksConstants.ADD_BUTTON)
    WebElement addButton;
	@FindBy(id=ManageSubTasksConstants.TASKHEADING)
    WebElement taskHeading;
	@FindBy(id=ManageSubTasksConstants.CLOSE_BUTTON)
    WebElement closeButton;

	public ManageSubTasksPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//method to create a subtask for a particular task
	public void createSubTask() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_Sub_task")));
		newSubTask.sendKeys("shriramsubtask");
		dueDate.clear();
		dueDate.sendKeys("08/12/2017");
		addButton.click();
		closeButton.click();
	}
	//method to create a subtask on press of the enter key
	public void createSubTaskOnEnterKey() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_Sub_task")));
		newSubTask.sendKeys("");
		newSubTask.sendKeys(Keys.ENTER);
	}
	//create a subtask without specifying the mandatory fields
	public void createSubTaskWithoutMandatoryFields(){
		newSubTask.sendKeys("");
		dueDate.clear();
		dueDate.sendKeys("");
		addButton.click();
		closeButton.click();
	}
	//method to check if the subtask is been created without the mandatory fields
	public Boolean checkMandatoryFields(){
		String text1=newSubTask.getText();
		String text2=dueDate.getText();
		if(text1 ==""&& text2==""){
			return true;
		}
		return false;
	}
	//method to check if the task name inside the manage subtasks modal dialog is read only
    public Boolean checkifReadOnly(){
    	if(editTask.isEnabled()){
    	return true;
    	}
    	return false;
    }
    //method to check if the subtask created has no more than 250 characters
    public Boolean checkSubTaskNameLength(){
    	List<WebElement> elements = driver.findElements((By) newSubTask);
    	for(WebElement element: elements){
    		if(element.getText().length()>250){
    			return true;
    		}
    		
    	}
    	return false;
    	
    }
}
