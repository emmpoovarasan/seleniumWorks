package test.datadriven;

import java.io.IOException;

import jxl.read.biff.BiffException;

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
		xlsUtil = new ExcelSheetDriver("E:\\Data.xls");
		//Load the Excel Sheet Col in to Dictionary for Further use in our Test cases.
		xlsUtil.ColumnDictionary();
	}
	@Before
	public void EnviromentalSetup(){
		driver.get("http://www.gmail.com");
	}
	@Test
	public void GmailLoginPage() throws InterruptedException{
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
}
