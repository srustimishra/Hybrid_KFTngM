package config;

import static test.java.HDriverScriptTest.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class UIOperation {

	WebDriver driver;
	WebDriverWait wait; 
	
	public UIOperation(WebDriver driver){
		
		this.driver=driver;
	    wait = new WebDriverWait(driver, 20);
	}
	
	public void perform(String sKeyword,String pageObject,String testData) throws Exception{
		
		
		switch(sKeyword){
		
		
	        
		case  "navigate":
			
			 Log.info("Navigating to URL");
	         driver.get("http://www.phptravels.net/");
	         break;
	         
		case "click":
			
			if(pageObject.equals("")==true){
				
			break;
			}
			else{
			 Log.info("Clicking on WebElement");
			By locator1=By.xpath(OR.getProperty(pageObject));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
				driver.findElement(locator1).click();
	         
	         }
			break;
	         
		case  "input":
			
			if(pageObject.equals("")==true || testData.equals("")==true){
				
				break;
			}
			else{
			Log.info("Entering input Text");
			By locator2= By.xpath(OR.getProperty(pageObject));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
			driver.findElement(locator2).sendKeys(testData);
            
            }
			break;
            
		case "closeBrowser":
			
			Log.info("Closing the Browser");
			driver.close();
			break;

		default:
			break;
		
		}
	}

}
