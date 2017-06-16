package test.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.ActionKeywords;
import config.UIOperation;
import utility.ExcelUtility;
import utility.Log;

public class HDriverScriptTest {
	
	public static Properties OR;
	public static WebDriver driver;
	public static ActionKeywords actionKeyword;
	public static String sActionKeyword;
	public static String sPageObject;
	public static String sData;
	public static String sTestSheet;
	public static boolean bResult;
	public static UIOperation operation;
	
   @BeforeMethod
   public void beforeMethod() throws IOException, InterruptedException{
	String ORPath = "C:\\Users\\india\\workspaceneon\\Hybrid_KF\\resources\\OR.txt";
	String ExcelPath = "C:\\Users\\india\\workspaceneon\\Hybrid_KF\\resources\\TestData.xlsx";
	ExcelUtility.setExcelFile(ExcelPath);
	
		FileInputStream fs;
		fs = new FileInputStream(ORPath);
		OR = new Properties(System.getProperties());
		OR.load(fs);
		DOMConfigurator.configure("log4j.xml");
        System.setProperty("webdriver.chrome.driver",
			"C://Users//india//Desktop//software imp//chromedriver_win32//chromedriver.exe");
	       driver = new ChromeDriver();
	       Log.info("Chrome Browser Started");
	
   }
   
   
   
   @Test
   public void ExecuteTest() throws Exception{
	   
	   UIOperation operation = new UIOperation(driver);
		
	   int testStepsCount = ExcelUtility.getRowCount("Login");
		System.out.println(testStepsCount);

		for (int j = 1; j <= testStepsCount; j++) {

			sActionKeyword = ExcelUtility.getCellData(j, 4, "Login");
            sPageObject = ExcelUtility.getCellData(j, 5, "Login");
            sData = ExcelUtility.getCellData(j, 6, "Login");

			System.out.println(sActionKeyword);
			System.out.println(sPageObject);
			System.out.println(sData);

			operation.perform(sActionKeyword, sPageObject, sData);

			if (bResult == true) {
				ExcelUtility.setCellData("PASS", j, 7, "Login");

			} else if (bResult == false) {
				ExcelUtility.setCellData("FAIL", j, 7,"Login");

			}
		
	}
		
   }
   
   
 /*  @DataProvider(name="hybridData")
   public Object[][] getTestCaseNames() throws Exception{
	   
	   Object[][] object=null;
	   
	  
	   int rowCount=ExcelUtility.getRowCount("TestCases");
	   object =new Object[rowCount][5];
	   
	   for (int i=1;i<=rowCount;i++)
	   {
       
		   for(int j=0;j<2;j++){
		  
		   object[i][1]=ExcelUtility.getCellData(i,j, "TestCases");
           System.out.println(object[i][j]);

	   }}
	   
	  return object;
	 
   }*/
   
   @AfterMethod
   public void afterMethod() {
 	 
       driver.quit();
   }

}
