package config;

import static test.java.HDriverScriptTest.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Log;

/**
 * Created by india on 5/18/2017.
 */
public class ActionKeywords {
    public static WebDriver driver;


    public  void openBrowser(){
    	System.setProperty("webdriver.chrome.driver","C://Users//india//Desktop//software imp//chromedriver_win32//chromedriver.exe");
        driver =new ChromeDriver();
        Log.info("Chrome Browser Started");
    }

    public void navigate(){
        try{
         Log.info("Navigating to URL");
         driver.get("http://www.phptravels.net/");
        }
        catch (Exception e){
            Log.info("Not able to navigate --- " + e.getMessage());

        }
    }
    
    public  void click_MyAccount(){
        try{
            Log.info("Clicking on WebElement");
            driver.findElement(By.xpath(OR.getProperty("btn_MyAccount"))).click();
        }
        catch (Exception e){
            Log.info("Not able to click" + e);
        }
    }

public  void click_Login(){
    try{
        Log.info("Clicking on WebElement");
        driver.findElement(By.xpath(OR.getProperty("sel_Login"))).click();
    }
    catch (Exception e){
        Log.info("Not able to click" + e);
    }
}

    public  void input_UserName() {
        try {
            Log.info("Entering input Text");
            driver.findElement(By.xpath(OR.getProperty("txt_UserName"))).sendKeys("srustimishraqms@gmail.com");
        } catch (Exception e) {
            Log.info("Not able to Input" + e);
        }
    }
    
    public  void input_Password() {
        try {
            Log.info("Entering input Text");
            driver.findElement(By.xpath(OR.getProperty("txt_Password"))).sendKeys("scarlet");

        } catch (Exception e) {
            Log.info("Not able to Input" + e);
        }
    }

  
    
    public  void click_btnLogin(){
        try{
            Log.info("Clicking on WebElement");
            driver.findElement(By.xpath(OR.getProperty("click_btnLogin"))).click();
        }
        catch (Exception e){
            Log.info("Not able to click" + e);
        }
    }
    
    
    public  void click_MyAccLogout(){
        try{
            Log.info("Clicking on WebElement");
            driver.findElement(By.xpath(OR.getProperty("sel_Logout"))).click();
        }
        catch (Exception e){
            Log.info("Not able to click" + e);
        }
    }

public  void click_btnlogout(){
    try{
        Log.info("Clicking on WebElement");
        driver.findElement(By.xpath(OR.getProperty("btn_Logout"))).click();
    }
    catch (Exception e){
        Log.info("Not able to click" + e);
    }
}

    public  void closeBrowser(){
        try{
            Log.info("Closing the browser");
            driver.quit();
        }
        catch (Exception e){
            Log.info("Not able to close Browser" + e);
        }
    }


}

