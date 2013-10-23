package test.keyworddriven;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestLogin {
	String[][] steps = null;
	WebDriver wd = null;
	@Before
	public void testSetup() throws BiffException, IOException{
		GetExcelData ge = new GetExcelData("C:\\Users\\POO\\git\\seleniumWorks\\seleniumWorks\\src\\test\\keyworddriven\\KeywordDriven.xls");
		
	}
	@Test
	public void testLogin() throws ArrayIndexOutOfBoundsException{
		steps = GetExcelData.extractDataFromExcel("Sheet1");
		
		// read excel data and store string arrays
		System.out.println(steps.length);
		/*String [][] crossword= new String[18][8];
		for(int i=0; i < crossword.length; i++){
			for(int j=0; j < crossword[i].length; j++){
				crossword[i][j]= " "+ i + j+" ";
				System.out.print(crossword[i][j]+"\t");
			}
			System.out.println();
		}*/
		for(int i = 1; i< steps.length; i++){
			if(steps[i][0].equalsIgnoreCase("Y")){
				if("open_browser".equalsIgnoreCase(steps[i][4])){
					System.out.println(steps[i][4]);
					wd = GetExcelData.open_browser(steps[i][7]);
					
				}else if("navigate_to".equalsIgnoreCase(steps[i][4])){
					System.out.println(steps[i][4]);
					GetExcelData.navigate_to(wd,steps[i][7]);
					
				}else if("refresh".equalsIgnoreCase(steps[i][4])){
					System.out.println(steps[i][4]);
					GetExcelData.refresh(wd);
					
				}else if("send_keys".equalsIgnoreCase(steps[i][4])){
					System.out.println(steps[i][4]);
					GetExcelData.send_keys(wd,steps[i][5],steps[i][6],steps[i][7]);
					
				}else if("click_element".equalsIgnoreCase(steps[i][4])){
					System.out.println(steps[i][4]);
					GetExcelData.click_element(wd,steps[i][5],steps[i][6]);
					
				}else if("verify_element".equalsIgnoreCase(steps[i][4])){
					System.out.println(steps[i][4]);
					GetExcelData.verify_element(wd,steps[i][5],steps[i][6]);
					
				}else if("close_browser".equalsIgnoreCase(steps[i][4])){
					System.out.println(steps[i][4]);
					GetExcelData.close_browser(wd);
				}else{
					System.out.println("else--"+steps[i][4]);
				}
			}
		}
		
	}

}
