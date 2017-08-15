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

import com.avenuecode.constants.CreateTaskConstants;



public class CreateTasksPage extends BasePage {
	private WebDriver driver;
	@FindBy(xpath=CreateTaskConstants.CREATETASK)
    WebElement createTask;
	@FindBy(xpath=CreateTaskConstants.ADD)
    WebElement add;
	@FindBy(xpath=CreateTaskConstants.AVENUECODE)
    WebElement avenueCode;
	@FindBy(xpath=CreateTaskConstants.TESTDESP)
    WebElement testDesp;
	@FindBy(xpath=CreateTaskConstants.BUGTRACKER)
    WebElement bugTracker;
	@FindBy(xpath=CreateTaskConstants.TABLE)
    WebElement table;
	@FindBy(xpath=CreateTaskConstants.MANAGESUBTASKS)
    WebElement manageSubTasks;
	@FindBy(xpath=CreateTaskConstants.CHECKBOX)
    WebElement checkbox;
	@FindBy(xpath=CreateTaskConstants.TASKTEXT)
    WebElement taskText;
	@FindBy(xpath=CreateTaskConstants.REMOVE)
    WebElement remove;
	@FindBy(xpath=CreateTaskConstants.DISPLAY_MESSAGE)
    WebElement displayMessage;
	@FindBy(xpath=CreateTaskConstants.EMPTYTASK_TEXTBOX)
    WebElement emptytask_textbox;
	@FindBy(xpath=CreateTaskConstants.TICK)
    WebElement tick;
	@FindBy(xpath=CreateTaskConstants.ERROR_MESSAGE)
    WebElement error_message;
	@FindBy(css=CreateTaskConstants.GROUP_OF_TASK_NAMES)
    WebElement groupofTaskNames;

	public CreateTasksPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	// to navigate to the manage sub tasks page for a particular task
	public ManageSubTasksPage manageSubTasks(){
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement table= wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
		WebElement tBody = table.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = tBody.findElements(By.tagName("tr"));
		System.out.println(tableRows.size());
		for(WebElement row: tableRows){
			if(row.findElement(By.xpath("td[contains(@class,'task_body col-md-7')]")).getText()=="shriram"){
				WebElement element=row.findElement(By.xpath("td[contains(@class,'btn btn-xs btn-primary ng-binding')]"));
				System.out.println(element);
			}
		}
		
		return  new ManageSubTasksPage(driver);
	}
	// to get the name of the sub tasks button and its value
	public void getNameOfSubTaskButton(){
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement table= wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
		WebElement tBody = table.findElement(By.tagName("tbody"));
		List<WebElement> totalRowCount = tBody.findElements(By.tagName("tr"));
		int rowIndex=1;
		for(WebElement rowElement:totalRowCount)
		{
		      List<WebElement> TotalColumnCount=rowElement.findElements(By.xpath("td"));
		      int ColumnIndex=1;
		      for(WebElement colElement:TotalColumnCount)
		      {
		    	  if(colElement.getText().contains("Manage Subtasks")){
		    		 String buttonName= colElement.getAttribute("value");
		    		 String number=buttonName.replaceAll("[^0-9]", "");
		    		 int numberofSubTasks=Integer.parseInt(number);
		    		 System.out.println("The number of sub tasks is "+numberofSubTasks+ " and the text on the button is"+buttonName);
		    	  }
		           System.out.println("Row "+rowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
		           ColumnIndex=ColumnIndex+1;
		       }
		      rowIndex=rowIndex+1;
		 }
		
	}
	//method to create a task
	public void createTask(){
		createTask.sendKeys("shriram123");
		add.click();
	}
	// to get the no of tasks for a user
	public void getRowCount(){
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement table= wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
		WebElement tBody = table.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = tBody.findElements(By.tagName("tr"));
		System.out.println(tableRows.size());		
	}
	//method to create a task without a name
	public void createTaskWithoutName(){
		String textInsideInputBox = createTask.getAttribute("value");
		// Check whether input field is blank
		if(textInsideInputBox.isEmpty())
		{
			add.click();
		   System.out.println("Input field is empty");
		}
		if(textInsideInputBox.isEmpty() &&!add.isEnabled()){
			createTask.sendKeys(Keys.ENTER);
		}
		
	}
    public String getDisplayMessage(){
    	WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement displayMessage1= wait.until(ExpectedConditions.visibilityOfElementLocated((By) displayMessage));
		return displayMessage.getText();
    }
    //to retrieve a task with an empty name
    public void getTaskWithEmptyName(){
    	WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement table= wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
		WebElement tBody = table.findElement(By.tagName("tbody"));
		List<WebElement> totalRowCount = tBody.findElements(By.tagName("tr"));
		int rowIndex=1;
		for(WebElement rowElement:totalRowCount)
		{
		      List<WebElement> TotalColumnCount=rowElement.findElements(By.xpath("td"));
		      int ColumnIndex=1;
		      for(WebElement colElement:TotalColumnCount)
		      {
		    	  if(colElement.getText().contains("empty")){
		    		 colElement.click();
		    		 WebDriverWait wait1 = new WebDriverWait(driver,5);
		    			WebElement textbox= wait1.until(ExpectedConditions.visibilityOfElementLocated((By) emptytask_textbox));
		    		 emptytask_textbox.sendKeys("shriram");
		    		 tick.click();
		    		 System.out.println(error_message.getText());	 
		    		 
		    	  }
		    
		           ColumnIndex=ColumnIndex+1;
		       }
		      rowIndex=rowIndex+1;
		 }
		
    	
    }
    //to check if the length of a task is greater than 3 and less than 250 characters.
    public Boolean checkTaskNameLength(){
    	List<WebElement> elements = driver.findElements((By) groupofTaskNames);
    	for(WebElement element: elements){
    		if(element.getText().length()<3 && element.getText().length()>250){
    			return true;
    		}
    		
    	}
    	return false;
    	
    }
}
