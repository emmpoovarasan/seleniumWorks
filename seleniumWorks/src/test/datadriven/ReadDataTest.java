package test.datadriven;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataTest {
	//Global initialization of Variables
	static ExcelSheetDriver xlsUtil;
	WebDriver driver = new FirefoxDriver();
	//Constructor to initialze Excel for Data source
	public ReadDataTest() throws BiffException, IOException{
		//Let's assume we have only one Excel File which holds all Testcases. weird :)  Just for Demo !!!
		//File f = new File("Data.xls");
		File f = new File("EMMDataDriven.xls");
		xlsUtil = new ExcelSheetDriver(f.getAbsolutePath());
		//Load the Excel Sheet Col in to Dictionary for Further use in our Test cases.
		xlsUtil.ColumnDictionary();
	}
	@Before
	public void EnviromentalSetup(){
		//driver.get("http://www.gmail.com");
		driver.get("https://guest:guest@sandbox.easymedmobile.com");
		driver.navigate().refresh();
		driver.manage().window().maximize();
	}
	@Test
	public void LoginTest() throws InterruptedException{
		for(int rowCnt = 1; rowCnt<xlsUtil.RowCount(); rowCnt++){
			WebElement txtEmail = driver.findElement(By.name("email"));
			txtEmail.clear();
			txtEmail.sendKeys(xlsUtil.ReadCell(xlsUtil.GetCell("Email"), rowCnt));
			
			WebElement txtPassWord = driver.findElement(By.name("password"));
			txtPassWord.clear();
			txtPassWord.sendKeys(xlsUtil.ReadCell(xlsUtil.GetCell("Password"), rowCnt));
			
			WebElement btnSignIn = driver.findElement(By.name("Login"));
			btnSignIn.click();
			if("Mobile Enabler for the Healthcare Industry".equalsIgnoreCase(driver.getTitle())){
				WebElement errorMessage = driver.findElement(By.id("loginMessageDiv"));
			    String strErrorMessage = errorMessage.getText();
			    System.out.println("Output is ---> "+strErrorMessage);
			}else if("Dashboard - International Medical Passport".equalsIgnoreCase(driver.getTitle())){
				System.out.println("Successfully Logged In... ---> "+driver.getTitle());
				WebElement logout = driver.findElement(By.linkText("Logout"));
				logout.click();
				System.out.println("Successfully logged out from Dashboard - International Medical Passport");
				driver.navigate().refresh();
			}
			/*try {
			      assertEquals("Mobile Enabler for the Healthcare Industry", driver.getTitle());
			      WebElement errorMessage = driver.findElement(By.id("loginMessageDiv"));
			      String strErrorMessage = errorMessage.getText();
			      System.out.println("Output is ---> "+strErrorMessage);
			    } catch (Error e) {
			    	
			      System.out.println("First Try Catch ------> "+e.getMessage());
			    }*/
			
			Thread.sleep(2000);
		}
	}
	/*@Test
	public void LogoutTest() throws InterruptedException{
		if("Dashboard - International Medical Passport".equalsIgnoreCase(driver.getTitle())){
			WebElement logout = driver.findElement(By.linkText("Logout"));
			logout.click();
			System.out.println("Successfully logged out from "+driver.getTitle());
		}
	}*/
	/*public void GmailLoginPage() throws InterruptedException{
		//Create a for loop.. for iterate through our Excel sheet for all the test cases.
		for(int rowCnt = 0; rowCnt < xlsUtil.RowCount(); rowCnt++){
			//Enter User Name by reading data from Excel
			WebElement userName = driver.findElement(By.name("Email"));
			userName.clear();
			userName.sendKeys(xlsUtil.ReadCell(xlsUtil.GetCell("EmailUserName"), rowCnt));
			
			// Enter Password
			
			WebElement passWord = driver.findElement(By.name("Passwd"));
			passWord.clear();
			passWord.sendKeys(xlsUtil.ReadCell(xlsUtil.GetCell("EmailPassWord"), rowCnt));
			
			//Click on the Sign In Button
			WebElement signIn = driver.findElement(By.name("signIn"));
			signIn.click();
			

			  //Sleep for some time,so that we can see things in action @ Screen :) 
			
			Thread.sleep(2000);
			
		}
		
	}
*/	
	@After
	public void CloseBrowser(){
		if("Mobile Enabler for the Healthcare Industry".equalsIgnoreCase(driver.getTitle())){
			driver.close();
			driver.quit();
			System.out.println("Successfully returned home page");
		}
		
	}
}
